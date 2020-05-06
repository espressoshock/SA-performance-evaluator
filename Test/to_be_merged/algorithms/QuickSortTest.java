package to_be_merged.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {


    @Test
    void sort() {
        System.out.println("Sort integer");
        int[] expected = {4,3,2,1};
        Arrays.sort(expected);
        assertArrayEquals(expected, new to_be_merged.algorithms.QuickSort().sort(new int[]{/*4,3,2,1*/1,2,3,4}));
    }

    @Test
    void testSort() {
        System.out.println("Sort string");
        String[] expected = {"d","c","b","a"};
        Arrays.sort(expected);
        assertArrayEquals(expected, new to_be_merged.algorithms.QuickSort().sort(new String[]{"a","b", "c", "d"/*"d","c","b","a"*/}));
    }

    @Test
    void getNAME() {
        System.out.println("Sort name");
        assertEquals(/*"quikc"*/"quick", new to_be_merged.algorithms.QuickSort().getNAME());
    }
}