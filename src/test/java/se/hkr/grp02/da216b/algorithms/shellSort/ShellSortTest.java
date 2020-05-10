package se.hkr.grp02.da216b.algorithms.shellSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {
    ShellSort shellSort = new ShellSort();
    Integer[] testInt = {5,4,3,2,1};
    String[] testString = {"5","4","3","2","1"};
    Integer[] testIntB = {5,4,3,2,1};
    String[] testStringB = {"5","4","3","2","1"};

    @Test
    void sort() {
        System.out.println("Sort :");
        Arrays.sort(testInt);
        Arrays.sort(testString);

        assertEquals(Arrays.toString(testInt), Arrays.toString(shellSort.sort(testIntB)));
        assertEquals(Arrays.toString(testString), Arrays.toString(shellSort.sort(testStringB)));
    }

    @Test
    void getNAME() {
        System.out.println("Get Name :");
        assertEquals("shell", shellSort.getNAME());
    }
}