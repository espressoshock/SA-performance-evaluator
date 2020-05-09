package se.hkr.grp02.da216b.algorithms.shellSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {
    ShellSort shellSortRecursive = new ShellSort();
    int[] testInt = {5,4,3,2,1};
    String[] testString = {"5","4","3","2","1"};

    @Test
    void sort() {
        System.out.println("Sort :");
        Arrays.sort(testInt);
        Arrays.sort(testString);
        //assertEquals(testInt, shellSortRecursive.sort(testInt));
        assertEquals(testString, shellSortRecursive.sort(testString));
    }

    @Test
    void getNAME() {
        System.out.println("Get Name :");
        assertEquals("shell", shellSortRecursive.getNAME());
    }
}