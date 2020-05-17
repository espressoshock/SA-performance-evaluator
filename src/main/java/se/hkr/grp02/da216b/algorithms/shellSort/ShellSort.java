package se.hkr.grp02.da216b.algorithms.shellSort;

import java.util.Arrays;

public class ShellSort<E extends Comparable<? super E>> {
    private final static String NAME = "shell"; //-> updated to static

    public String getNAME() {
        return NAME;
    }

    public E[] sort(E[] array) {
        E[] sortedArray = array;
        int j;
        //Gap size Array.length/2, loop until gap = 0
        for (int gap = sortedArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                E tmp = sortedArray[i];
                for (j = i; j >= gap && tmp.compareTo(sortedArray[j - gap]) < 0; j -= gap) {
                sortedArray[j] = sortedArray[j-gap];
                }
                sortedArray[j] = tmp;
            }
        }
        System.out.println(Arrays.toString(sortedArray));
        return sortedArray;
    }
}
