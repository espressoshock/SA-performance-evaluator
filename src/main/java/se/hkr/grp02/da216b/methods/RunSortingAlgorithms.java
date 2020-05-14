package se.hkr.grp02.da216b.methods;

import se.hkr.grp02.da216b.DAL.IDBManager;
import se.hkr.grp02.da216b.HIBDB.ECRTLEntry;
import se.hkr.grp02.da216b.algorithms.heapSort.HeapSortRecursive;
import se.hkr.grp02.da216b.algorithms.mergeSort.MergeSortRecursive;
import se.hkr.grp02.da216b.algorithms.quickSort.QuickSortRecursiveFP;
import se.hkr.grp02.da216b.algorithms.shellSort.ShellSort;
import se.hkr.grp02.da216b.utilities.Algorithms;
import se.hkr.grp02.da216b.utilities.Result;
import se.hkr.grp02.da216b.utilities.Timer;
import se.hkr.grp02.da216b.workloads.IntWorkload;
import se.hkr.grp02.da216b.workloads.StringWorkload;
import se.hkr.grp02.da216b.workloads.Workload;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RunSortingAlgorithms {
    private Algorithms algorithms;
    private Workload workload;
    private ArrayList<Result> results = new ArrayList<>();
    private Timer timer = new Timer();
    private Scanner scanner = new Scanner(System.in);
    //////////******Result Lists from DB******///////////////
    List<ECRTLEntry> heapSortStringResults;
    List<ECRTLEntry> heapSortIntegerResults;
    List<ECRTLEntry> shellSortStringResults;
    List<ECRTLEntry> shellSortIntegerResults;
    List<ECRTLEntry> mergeSortStringResults;
    List<ECRTLEntry> mergeSortIntegerResults;
    List<ECRTLEntry> quickSortStringResults;
    List<ECRTLEntry> quickSortIntegerResults;

    //////////******Result Lists from DB******///////////////

    /**
     * running one test
     */
    public void run() {
        // choose workload size and case
        chooseWorkload();
        // choose algorithms to be tested
        chooseAlgorithms();
        // run algorithms
        // save results
        testAlgorithms();
        // return results
        printResults();
    }

    /**
     * Returns the average value of the results
     *
     * @param algorithm running results
     * @return the average value
     */
    public long getAverage(ArrayList<Long> algorithm) {
        double average = algorithm.stream().mapToLong(val -> val).average().orElse(0);
        return (new Double(average)).longValue();
    }

    /**
     * For each tested algorithm print the average result
     */
    public void printResults() {
        ArrayList<Long> heapResults = new ArrayList<>();
        ArrayList<Long> mergeResults = new ArrayList<>();
        ArrayList<Long> quickResults = new ArrayList<>();
        ArrayList<Long> shellResults = new ArrayList<>();
        groupResults(heapResults, mergeResults, quickResults, shellResults);
        if (heapResults.size() > 0) {
            System.out.println("The average running time for HeapSort is: " + getAverage(heapResults));
// push here
            pushToDB(getAverage(heapResults), "HeapSort");
        }
        if (mergeResults.size() > 0) {
            System.out.println("The average running time for MergeSort is: " + getAverage(mergeResults));
            pushToDB(getAverage(mergeResults), "MergeSort");
        }
        if (quickResults.size() > 0) {
            System.out.println("The average running time for QuickSort is: " + getAverage(quickResults));
            pushToDB(getAverage(quickResults), "QuickSort");
        }
        if (shellResults.size() > 0) {
            System.out.println("The average running time for ShellSort is: " + getAverage(shellResults));
            pushToDB(getAverage(shellResults), "ShellSort");
        }
    }

    public void pushToDB(Long result, String algoName) {
        String[] cases = new String[]{"Average case", "Worst case"};
        if (workload.getIntWorkload() != null) {
            IDBManager.insertRTLEntry(new ECRTLEntry(result.toString(), workload.getIntWorkload().getCaseName(), "INT", algoName,
                    String.valueOf(workload.getIntWorkload().getWorkload().length)));
        } else if (workload.getStringWorkload() != null) {
            IDBManager.insertRTLEntry(new ECRTLEntry(result.toString(), workload.getStringWorkload().getCaseName(), "STR", algoName,
                    String.valueOf(workload.getStringWorkload().getWorkload().length)));
        }
    }

    public void pullFromDB() {
        Connection connection = IDBManager.getConnection();

        List<ECRTLEntry> dbResults = IDBManager.getAllRTLEntries();
        heapSortStringResults = extractResultsByType(dbResults, "STR", "HeapSort");
        heapSortIntegerResults = extractResultsByType(dbResults, "INT", "HeapSort");
        quickSortStringResults = extractResultsByType(dbResults, "STR", "QuickSort");
        quickSortIntegerResults = extractResultsByType(dbResults, "INT", "QuickSort");
        shellSortStringResults = extractResultsByType(dbResults, "STR", "ShellSort");
        shellSortIntegerResults = extractResultsByType(dbResults, "INT", "ShellSort");
        mergeSortStringResults = extractResultsByType(dbResults, "STR", "MergeSort");
        mergeSortIntegerResults = extractResultsByType(dbResults, "INT", "MergeSort");
    }

    public void printDBResults() {
        int choice = 0;
        System.out.println("Chose option: ");
        System.out.println("1. print results for Integer sorts");
        System.out.println("2. print results for String sorts");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printResultMenu("INT");
                break;
            case 2:
                printResultMenu("STR");
                break;
        }
    }

    public void printResultMenu(String workloadType) {
        int choice = 0;
        System.out.println("Chosen workload type:" + workloadType + "\nChose option: ");
        System.out.println("1. print results for QuickSort");
        System.out.println("2. print results for ShellSort");
        System.out.println("3. print results for MergeSort");
        System.out.println("4. print results for HeapSort");
        choice = scanner.nextInt();
        int from = 0;
        int to = 0;
        switch (choice) {
            case 1:
                System.out.println("Chose workoad size lower bound: (show all from:)");
                from = scanner.nextInt();
                System.out.println("Chose workoad size upper bound: (show all up to:)");
                to = scanner.nextInt();
                if (workloadType.equals("INT")) {
                    printFromTo(from, to, quickSortIntegerResults);
                } else if (workloadType.equals("STR"))
                    printFromTo(from, to, quickSortStringResults);
                break;
            case 2:
                System.out.println("Chose workload size lower bound: (show all from:)");
                from = scanner.nextInt();
                System.out.println("Chose workload size upper bound: (show all up to:)");
                to = scanner.nextInt();
                if (workloadType.equals("INT")) {
                    printFromTo(from, to, shellSortIntegerResults);
                } else if (workloadType.equals("STR"))
                    printFromTo(from, to, shellSortStringResults);
                break;
            case 3:
                System.out.println("Chose workload size lower bound: (show all from:)");
                from = scanner.nextInt();
                System.out.println("Chose workload size upper bound: (show all up to:)");
                to = scanner.nextInt();
                if (workloadType.equals("INT")) {
                    printFromTo(from, to, mergeSortIntegerResults);
                } else if (workloadType.equals("STR"))
                    printFromTo(from, to, mergeSortStringResults);
                break;
            case 4:
                System.out.println("Chose workload size lower bound: (show all from:)");
                from = scanner.nextInt();
                System.out.println("Chose workload size upper bound: (show all up to:)");
                to = scanner.nextInt();
                if (workloadType.equals("INT")) {
                    printFromTo(from, to, heapSortIntegerResults);
                } else if (workloadType.equals("STR"))
                    printFromTo(from, to, heapSortStringResults);
                break;
        }
    }

    public void printFromTo(int from, int to, List<ECRTLEntry> dbResults) {
        List<ECRTLEntry> fromTo = new ArrayList<>();
        for (ECRTLEntry x : dbResults
        ) {
            if (Long.valueOf(x.getWorkload()) >= from && Long.valueOf(x.getWorkload()) <= to) {
                fromTo.add(x);
            }
        }
        System.out.println(String.format("%S", "-----------------------------------------------------------------------------------------"));
        System.out.println(String.format("%14s %16s %14s %16s %20s", "ALGORITHM NAME", "WORKLOAD TYPE", "CASE TYPE", "WORKLOAD SIZE", "RUNNING TIME"));
        System.out.println(String.format("%S", "-----------------------------------------------------------------------------------------"));
        for (ECRTLEntry y : fromTo
        ) {
            System.out.println(String.format("%10s %16s %18s %12s %22s", y.getAlgorithmFK(), y.getTargetOS(), y.getTargetlang(),y.getWorkload(), y.getRtrResult()));
        }
    }

    public List<ECRTLEntry> extractResultsByType(List<ECRTLEntry> list, String workloadType, String algorithmType) {
        List<ECRTLEntry> extracted = new ArrayList<>();
        for (ECRTLEntry x : list) {
            if (x.getTargetOS().equals(workloadType) && x.getAlgorithmFK().equals(algorithmType)) {
                extracted.add(x);
            }
        }
        return extracted;
    }

    /**
     * Sort the results based on the type of the algorithm being used
     *
     * @param heapResults  input
     * @param mergeResults input
     * @param quickResults input
     * @param shellResults input
     */
    public void groupResults(ArrayList<Long> heapResults, ArrayList<Long> mergeResults,
                             ArrayList<Long> quickResults, ArrayList<Long> shellResults) {

        for (Result r : results) {
            switch (r.getAlgorithmName()) {
                //////// Could not run on my PC, I do not have level 14 for project (Nemanja)
//                case "heap" -> heapResults.add(r.getTime());
//                case "merge" -> mergeResults.add(r.getTime());
//                case "quick" -> quickResults.add(r.getTime());
//                case "shell" -> shellResults.add(r.getTime());
                case "heap":
                    heapResults.add(r.getTime());
                    break;
                case "merge":
                    mergeResults.add(r.getTime());
                    break;
                case "quick":
                    quickResults.add(r.getTime());
                    break;
                case "shell":
                    shellResults.add(r.getTime());
                    break;
            }
        }
    }

    /**
     * Iterates the test the chosen number of times
     */
    public void testAlgorithms() {
        System.out.println("Enter the desired amount of iterations: ");
        boolean integer;
        int choice = 0;
        do {
            try {
                integer = false;
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 20) {
                    System.out.println("\u001B[34m" + "Please choose between 1 and 20 iterations" + "\u001B[0m");
                    integer = true;
                } else {
                    System.out.println("\u001B[34m" + "Valid input" + "\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[34m" + "Please enter a valid input" + "\u001B[0m");
                integer = true;
            }
        } while (integer);
        while (choice > 0) {
            runAlgorithms();
            choice--;
        }
        System.out.println("Sorting ... ");
    }

    /**
     * Runs selected algorithms
     */
    public void runAlgorithms() {
        if (algorithms.getHeapSort() != null) {
            if (workload.getIntWorkload() != null) {
                timer.startTimer();
                algorithms.getHeapSort().sort(workload.getIntWorkload().getIntegerWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getHeapSort().getNAME(), workload));
            } else if (workload.getStringWorkload() != null) {
                timer.startTimer();
                algorithms.getHeapSort().sort(workload.getStringWorkload().getWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getHeapSort().getNAME(), workload));
            }
        }
        if (algorithms.getMergeSort() != null) {
            if (workload.getIntWorkload() != null) {
                timer.startTimer();
                algorithms.getMergeSort().sort(workload.getIntWorkload().getIntegerWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getMergeSort().getNAME(), workload));
            } else if (workload.getStringWorkload() != null) {
                timer.startTimer();
                algorithms.getMergeSort().sort(workload.getStringWorkload().getWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getMergeSort().getNAME(), workload));
            }
        }
        if (algorithms.getQuickSort() != null) {
            if (workload.getIntWorkload() != null) {
                timer.startTimer();
                algorithms.getQuickSort().sort(workload.getIntWorkload().getIntegerWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getQuickSort().getNAME(), workload));
            } else if (workload.getStringWorkload() != null) {
                timer.startTimer();
                algorithms.getQuickSort().sort(workload.getStringWorkload().getWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getQuickSort().getNAME(), workload));
            }
        }
        if (algorithms.getShellSort() != null) {
            if (workload.getIntWorkload() != null) {
                timer.startTimer();
                algorithms.getShellSort().sort(workload.getIntWorkload().getIntegerWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getShellSort().getNAME(), workload));
            } else if (workload.getStringWorkload() != null) {
                timer.startTimer();
                algorithms.getShellSort().sort(workload.getStringWorkload().getWorkload());
                timer.stopTimer();
                results.add(new Result(timer.getTime(), algorithms.getShellSort().getNAME(), workload));
            }
        }
    }

    /**
     * set the workload
     */
    public void chooseWorkload() {
        boolean integer;
        int[] upLimit = {2, 2, 1000000};
        int[] choices = new int[3];
        String[] prompts = {"Select: \n[1]    Average case\n[2]    Worst Case",
                "Select: \n[1]    Integer\n[2]    String\n",
                "Select a number between 10 and 1.000.000 \nas the size of your workload ",
                "\u001B[34m" + "Valid input" + "\u001B[0m",
                "\u001B[34m" + "Please enter a valid input" + "\u001B[0m"};
        for (int i = 0; i < 3; i++) {
            System.out.println(prompts[i]);
            do {
                try {
                    integer = false;
                    choices[i] = Integer.parseInt(scanner.nextLine());
                    if (choices[i] < 1 || choices[i] > upLimit[i]) {
                        System.out.println(prompts[4]);
                        integer = true;
                    } else {
                        System.out.println(prompts[3]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(prompts[4]);
                    integer = true;
                }
            } while (integer);
        }
        System.out.println("Creating the workload ...");
        createWorkload(choices[0], choices[1], choices[2]);
    }

    /**
     * use the user choices to create the workload
     *
     * @param caseLevel average or worst
     * @param type      int or String
     * @param size      up to 1 million
     */
    public void createWorkload(int caseLevel, int type, int size) {
        switch (type) {
            case 1:
                this.workload = new Workload(new IntWorkload(caseLevel, size));
                break;
            case 2:
                this.workload = new Workload(new StringWorkload(caseLevel, size));
                break;
            default:
                break;
        }
    }

    /**
     * set the algorithms to run
     */
    public void chooseAlgorithms() {
        printAlgorithmsOptions();
        boolean integer;
        int choice = 0;
        do {
            try {
                integer = false;
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 15) {
                    System.out.println("\u001B[34m" + "Please enter a valid input" + "\u001B[0m");
                    integer = true;
                } else {
                    System.out.println("\u001B[34m" + "Valid input" + "\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[34m" + "Please enter a valid input" + "\u001B[0m");
                integer = true;
            }
        } while (integer);
        setAlgorithms(choice);
    }

    /**
     * get selected algorithm to perform
     *
     * @return performing algorithms
     */
    public Algorithms getAlgorithms() {
        return this.algorithms;
    }

    /**
     * get the workload
     *
     * @return workload
     */
    public Workload getWorkload() {
        return this.workload;
    }

    /**
     * load results to DB
     */
    public void loadResults() {

    }

    /**
     * prompt algorithm selection
     */
    public void printAlgorithmsOptions() {
        System.out.println("Select the algorithm set to perform testing:\n");
        System.out.println("[1]    Heap");
        System.out.println("[2]    Merge");
        System.out.println("[3]    Quick");
        System.out.println("[4]    Shell");
        System.out.println("[5]    Heap and Merge");
        System.out.println("[6]    Heap and Quick");
        System.out.println("[7]    Heap and Shell");
        System.out.println("[8]    Merge and Quick");
        System.out.println("[9]    Merge and Shell");
        System.out.println("[10]   Quick and Shell");
        System.out.println("[11]   Heap, Merge, and Quick");
        System.out.println("[12]   Heap, Merge, and Shell");
        System.out.println("[13]   Heap, Quick, and Shell");
        System.out.println("[14]   Merge, Quick, and Shell");
        System.out.println("[15]   Heap, Merge, Quick, Shell");
    }

    /**
     * set the algorithms user wants to test
     *
     * @param choice the index of the combination of algorithms
     */
    public void setAlgorithms(int choice) {
        switch (choice) {
            case 1:
                this.algorithms = new Algorithms(new HeapSortRecursive());
                break;
            case 2:
                this.algorithms = new Algorithms(new MergeSortRecursive());
                break;
            case 3:
                this.algorithms = new Algorithms(new QuickSortRecursiveFP());
                break;
            case 4:
                this.algorithms = new Algorithms(new ShellSort());
                break;
            case 5:
                this.algorithms = new Algorithms(new HeapSortRecursive(), new MergeSortRecursive());
                break;
            case 6:
                this.algorithms = new Algorithms(new HeapSortRecursive(), new QuickSortRecursiveFP());
                break;
            case 7:
                this.algorithms = new Algorithms(new HeapSortRecursive(), new ShellSort());
                break;
            case 8:
                this.algorithms = new Algorithms(new MergeSortRecursive(), new QuickSortRecursiveFP());
                break;
            case 9:
                this.algorithms = new Algorithms(new MergeSortRecursive(), new ShellSort());
                break;
            case 10:
                this.algorithms = new Algorithms(new QuickSortRecursiveFP(), new ShellSort());
                break;
            case 11:
                this.algorithms = new Algorithms(new HeapSortRecursive(), new MergeSortRecursive(), new QuickSortRecursiveFP());
                break;
            case 12:
                this.algorithms = new Algorithms(new HeapSortRecursive(), new MergeSortRecursive(), new ShellSort());
                break;
            case 13:
                this.algorithms = new Algorithms(new HeapSortRecursive(), new QuickSortRecursiveFP(), new ShellSort());
                break;
            case 14:
                this.algorithms = new Algorithms(new MergeSortRecursive(), new QuickSortRecursiveFP(), new ShellSort());
                break;
            case 15:
                this.algorithms = new Algorithms(new HeapSortRecursive(), new MergeSortRecursive(), new QuickSortRecursiveFP(), new ShellSort());
                break;
            default:
                break;
        }
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setWorkload(Workload workload) {
        this.workload = workload;
    }
}
