package se.hkr.grp02.da216b.algorithms.mergeSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortRecursiveTest {

    MergeSortRecursive mergeSortRecursive = new MergeSortRecursive();
    Integer[] testInt = {5,4,3,2,1};
    String[] testString = {"5","4","3","2","1"};

    @Test
    void sort() {
        System.out.println("Sort :");
        Arrays.sort(testInt);
        Arrays.sort(testString);
        assertEquals(Arrays.toString(testInt), Arrays.toString(mergeSortRecursive.sort(testInt)));
        assertEquals(Arrays.toString(testString), Arrays.toString(mergeSortRecursive.sort(testString)));
    }

    @Test
    void getNAME() {
        System.out.println("Get Name :");
        assertEquals("merge", mergeSortRecursive.getNAME());
    }
}