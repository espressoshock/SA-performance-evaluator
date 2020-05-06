package se.hkr.grp02.da216b.utilities;

import org.junit.jupiter.api.Test;
import se.hkr.grp02.da216b.algorithms.heapSort.HeapSortRecursive;
import se.hkr.grp02.da216b.algorithms.mergeSort.MergeSortRecursive;
import se.hkr.grp02.da216b.algorithms.quickSort.QuickSortRecursiveFP;
import se.hkr.grp02.da216b.algorithms.shellSort.ShellSortRecursive;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {
    Algorithms algorithms = new Algorithms(new HeapSortRecursive(), new MergeSortRecursive(), new QuickSortRecursiveFP(), new ShellSortRecursive());

    @Test
    void getHeapSort() {
        System.out.println("Get HeapSort");
        assertTrue(algorithms.getHeapSort() instanceof HeapSortRecursive);
    }

    @Test
    void getMergeSort() {
        System.out.println("Get MergeSort");
        assertTrue(algorithms.getMergeSort() instanceof MergeSortRecursive);
    }

    @Test
    void getQuickSort() {
        System.out.println("Get QuickSort");
        assertTrue(algorithms.getQuickSort() instanceof QuickSortRecursiveFP);
    }

    @Test
    void getShellSort() {
        System.out.println("Get ShellSort");
        assertTrue(algorithms.getShellSort() instanceof ShellSortRecursive);
    }
}