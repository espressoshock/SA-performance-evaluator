package to_be_merged.resources;

import org.junit.jupiter.api.Test;
import to_be_merged.algorithms.HeapSort;
import to_be_merged.algorithms.MergeSort;
import to_be_merged.algorithms.QuickSort;
import to_be_merged.algorithms.ShellSort;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    Algorithms algorithms = new Algorithms(new HeapSort(), new MergeSort(), new QuickSort(), new ShellSort());

    @Test
    void getHeapSort() {
        System.out.println("Get HeapSort");
        assertTrue(algorithms.getHeapSort() instanceof HeapSort);
    }

    @Test
    void getMergeSort() {
        System.out.println("Get MergeSort");
        assertTrue(algorithms.getMergeSort() instanceof MergeSort);
    }

    @Test
    void getQuickSort() {
        System.out.println("Get QuickSort");
        assertTrue(algorithms.getQuickSort() instanceof QuickSort);
    }

    @Test
    void getShellSort() {
        System.out.println("Get ShellSort");
        assertTrue(algorithms.getShellSort() instanceof ShellSort);
    }
}