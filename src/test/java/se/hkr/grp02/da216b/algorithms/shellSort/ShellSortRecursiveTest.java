package se.hkr.grp02.da216b.algorithms.shellSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {
    ShellSort shellSortRecursive = new ShellSort();
    int[] testInt = {5,4,3,2,1};
    String[] testString = {"5","4","3","2","1"};
    int[] testIntB = {5,4,3,2,1};
    String[] testStringB = {"5","4","3","2","1"};

    @Test
    void sort() {
        System.out.println("Sort :");
        Arrays.sort(testInt);
        Arrays.sort(testString);

        assertEquals(Arrays.toString(testInt), Arrays.toString(shellSortRecursive.sort(testIntB)));
        assertEquals(Arrays.toString(testString), Arrays.toString(shellSortRecursive.sort(testStringB)));
    }

    @Test
    void getNAME() {
        System.out.println("Get Name :");
        assertEquals("shell", shellSortRecursive.getNAME());
    }
}