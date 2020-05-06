package to_be_merged.resources;

import org.junit.jupiter.api.Test;
import to_be_merged.algorithms.HeapSort;
import to_be_merged.workloads.IntWorkload;
import to_be_merged.workloads.Workload;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    Result result = new Result(1000, new HeapSort().getNAME(), new Workload(new IntWorkload(1, 100)));
    @Test
    void getTime() {
        System.out.println("Get time");
        assertEquals(1000, result.getTime());
    }

    @Test
    void setTime() {
        System.out.println("Set time");
        result.setTime(2000);
        assertEquals(2000, result.getTime());
    }

    @Test
    void getAlgorithmName() {
        System.out.println("Get algorithm name");
        assertEquals("heap", result.getAlgorithmName());
    }

    @Test
    void setAlgorithmName() {
        System.out.println("Set algorithm name");
        result.setAlgorithmName("merge");
        assertEquals("merge", result.getAlgorithmName());
    }

    @Test
    void getWorkload() {
        System.out.println("Get workload");
        assertTrue(result.getWorkload() instanceof Workload);
    }

    @Test
    void setWorkload() {
        System.out.println("Set workload");
        Workload expected =  new Workload(new IntWorkload(2, 100));
        result.setWorkload(expected);
        assertEquals(expected, result.getWorkload());
    }

}