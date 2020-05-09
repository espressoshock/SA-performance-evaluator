package se.hkr.grp02.da216b.algorithms.shellSort;

/**
 * https://big-o.io/examples/shellsort/java-generic/
 *
 * Modified by Nemanja Negovanovic
 * ShellSort - Generic
 * @param <E> - Any comparable element type
 */
public class ShellSort<E extends Comparable<? super E>> {
    ///////******** =IMPORTED ///////********
    private final static String NAME = "shell"; //-> updated to static
//    public int[] sort(int[] workload) {
//        return workload;
//    }
//    public String[] sort(String[] workload) {
//        return workload;
//    }

    public String getNAME() {
        return NAME;
    }
    ///////******** =IMPORTED ///////********
    public E[] sort(E[] array) {
        E[] sortedArray = array;
        //Gap size Array.length/2, loop until gap = 0
        for (int gapSize = sortedArray.length / 2; gapSize > 0; gapSize /= 2) {
            for (int currentIndex = gapSize; currentIndex < array.length; currentIndex++) {
                // save the currentIndex
                int currentIndexCopy = currentIndex;
                // save the value of the currentIndex
                E item = sortedArray[currentIndex];
                while (currentIndexCopy >= gapSize && array[currentIndexCopy - gapSize].compareTo(item) > 0) {
                    sortedArray[currentIndexCopy] = sortedArray[currentIndexCopy - gapSize];
                    currentIndexCopy -= gapSize;
                }
                sortedArray[currentIndexCopy] = item;
            }
        }
        return sortedArray;
    }
}
