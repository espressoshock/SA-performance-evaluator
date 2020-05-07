package se.hkr.grp02.da216b.algorithms.heapSort;

import org.junit.jupiter.api.Test;
import se.hkr.grp02.da216b.algorithms.mergeSort.MergeSortRecursive;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortRecursiveTest {

    HeapSortRecursive heapSortRecursive = new HeapSortRecursive();
    int[] testInt = {5,4,3,2,1};
    String[] testString = {"5","4","3","2","1"};

    @Test
    void sort() {
        System.out.println("Sort :");
        Arrays.sort(testInt);
        Arrays.sort(testString);
        assertEquals(testInt, heapSortRecursive.sort(testInt));
        assertEquals(testString, heapSortRecursive.sort(testString));
    }

    @Test
    void getNAME() {
        System.out.println("Get Name :");
        assertEquals("heap", heapSortRecursive.getNAME());
    }
}