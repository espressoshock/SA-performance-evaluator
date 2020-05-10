package se.hkr.grp02.da216b.algorithms.heapSort;

import org.junit.jupiter.api.Test;
import se.hkr.grp02.da216b.algorithms.mergeSort.MergeSortRecursive;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortRecursiveTest {

    HeapSortRecursive heapSortRecursive = new HeapSortRecursive();
    Integer[] testInt = {5,4,3,2,1};
    Integer[] testIntB = {5,4,3,2,1};
    String[] testStringB = {"5","4","3","2","1"};
    String[] testString = {"5","4","3","2","1"};


    @Test
    void sort() {
        System.out.println("Sort :");
        Arrays.sort(testInt);
        Arrays.sort(testString);

        assertEquals(testInt, heapSortRecursive.sort(testIntB));
        assertEquals(testString, heapSortRecursive.sort(testStringB));
    }

    @Test
    void getNAME() {
        System.out.println("Get Name :");
        assertEquals("heap", heapSortRecursive.getNAME());
    }
}