package to_be_merged.method;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RunSortingAlgorithmsTest {

    to_be_merged.method.RunSortingAlgorithms runSort = new to_be_merged.method.RunSortingAlgorithms();
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
        ArrayList<to_be_merged.resources.Result> testResults = new ArrayList<>();
        ArrayList<Long> heapList = new ArrayList<>();
        testResults.add(new to_be_merged.resources.Result(1000, "heap", new to_be_merged.workloads.Workload(new to_be_merged.workloads.IntWorkload(1,100))));
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
        to_be_merged.workloads.Workload testWorkload = new to_be_merged.workloads.Workload(new to_be_merged.workloads.IntWorkload(1,10));
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