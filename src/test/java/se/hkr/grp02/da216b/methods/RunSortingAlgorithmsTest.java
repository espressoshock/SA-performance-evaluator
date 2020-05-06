package se.hkr.grp02.da216b.methods;

import org.junit.jupiter.api.Test;
import se.hkr.grp02.da216b.utilities.Result;
import se.hkr.grp02.da216b.workloads.IntWorkload;
import se.hkr.grp02.da216b.workloads.Workload;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RunSortingAlgorithmsTest {
    RunSortingAlgorithms runSort = new RunSortingAlgorithms();
    @Test
    void run() {

    }

    @Test
    void getAverage() {
        System.out.println("Get Average");
        ArrayList<Long> testArrayList = new ArrayList<>();
        testArrayList.add(new Long(100));
        testArrayList.add(new Long(300));
        assertEquals(200,runSort.getAverage(testArrayList));
    }

    @Test
    void printResults() {
        System.out.println("Print results");
        ArrayList<Long> testResults = new ArrayList<>();
        testResults.add(new Long(100));
        testResults.add(new Long(300));
        assertTrue(""+runSort.getAverage(testResults) instanceof String);
    }

    @Test
    void groupResults() {
        System.out.println("Group results");
        ArrayList<Result> testResults = new ArrayList<>();
        ArrayList<Long> heapList = new ArrayList<>();
        testResults.add(new Result(1000, "heap", new Workload(new IntWorkload(1,100))));
        heapList.add(testResults.get(0).getTime());
        assertTrue(heapList.size()>0);
    }

    @Test
    void testAlgorithms() {
        System.out.println("Test algorithms");
        int test = 0;
        for (int i = 0; i<4; i++){
            test++;
        }
        assertTrue(4 == test);
    }

    @Test
    void runAlgorithms() {
        System.out.println("Run algorithms");
        runSort.setAlgorithms(1);
        assertTrue(runSort.getAlgorithms().getHeapSort()!=null);
    }

    @Test
    void chooseWorkload() {
        System.out.println("Chose workload");

    }

    @Test
    void createWorkload() {
        System.out.println("Create workload");
        runSort.createWorkload(1,2,10);
        assertTrue(runSort.getWorkload().getStringWorkload().getWorkload() instanceof String[]);
        assertTrue(runSort.getWorkload().getStringWorkload().getWorkload()!= null);
    }

    @Test
    void chooseAlgorithms() {
        System.out.println("Choose algorithms");
    }

    @Test
    void getAlgorithms() {
        System.out.println("Get Algorithms");
        runSort.setAlgorithms(1);
        assertTrue(runSort.getAlgorithms()!=null);
    }

    @Test
    void getWorkload() {
        System.out.println("Get Workload");
        Workload testWorkload = new Workload(new IntWorkload(1,10));
        runSort.setWorkload(testWorkload);
        assertEquals(testWorkload, runSort.getWorkload());
    }

    @Test
    void loadResults() {
        System.out.println("Load Results");
    }

    @Test
    void printAlgorithmsOptions() {
        System.out.println("Print algorithm options");
    }

    @Test
    void setAlgorithms() {
        System.out.println("Set algorithms");
        runSort.setAlgorithms(11); // Heap, Merge and Quick
        assertTrue(runSort.getAlgorithms().getHeapSort()!=null);
        assertTrue(runSort.getAlgorithms().getMergeSort()!=null);
        assertTrue(runSort.getAlgorithms().getQuickSort()!=null);
        assertTrue(runSort.getAlgorithms().getShellSort()==null);
    }
}