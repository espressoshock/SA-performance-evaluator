package se.hkr.grp02.da216b.algorithms.quickSort;

/***
 * QUICKSORT - RECURSIVE IMPL. FIRST PIVOT STRATEGY (P=0).
 */
public class QuickSortRecursiveFP {
    ///////******** =IMPORTED ///////********
    private final static String NAME = "quick"; //-> updated to static
  /* */ public int[] sort(int[] workload) {
        return workload;
    }
    public String[] sort(String[] workload) {
        return workload;
    }
    public String getNAME() {
        return NAME;
    }
    ///////******** =IMPORTED ///////********

    /**
     * used to start with the whole list and find the first left and right values
     *
     * @param array the initial list
     * @param <E>   the type
     */
    public static <E extends Comparable<? super E>> void sort(E[] array) {
        quickSort(array, 0, array.length - 1);// start the sort with the entire list
    }

    /**
     * used to sort partitions
     *
     * @param array the list
     * @param from  pointer to the start
     * @param to    pointer to the end
     * @param <E>   type
     */
    //this method is called recursively to solve the partitions
    private static <E extends Comparable<? super E>> void quickSort(E[] array, int from, int to) {
        //if there is more than one element of the array to be sorted
        if (from < to + 1) {
            int pivotIndex = partition(array, from, to);
            quickSort(array, from, pivotIndex - 1);// recursive call for the left partition
            quickSort(array, pivotIndex + 1, to);// recursive call for the right partition
        }
        // else the partition is already sorted
    }

    /**
     * to a given list, the method will swap element at index a with the one at index b
     *
     * @param array input
     * @param a     element to swap
     * @param b     element to swap
     * @param <E>   the type of elements
     */
    public static <E> void swapReferences(E[] array, int a, int b) {
        // a temporary E instance is used to store first element to swap
        E temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static int firstPivot(int left) {
        return left;
    }

    /**
     *
     *
     * @param array input
     * @param left  start from
     * @param right up to
     * @param <E>   elements type
     * @return the index value of the pivot
     */
    public static <E extends Comparable<? super E>> int partition(E[] array, int left, int right) {
        //a pivot is found, moved at the beginning of the sorting space
        swapReferences(array, left, firstPivot(left));
        int border = left + 1;//start comparing from next element after pivot
        for (int i = border; i <= right; i++) {
            // if the compared element is smaller than the pivot, swap it with the border value
            if (array[i].compareTo(array[left]) < 0) {
                swapReferences(array, i, border++);
            }
        }
        // bring the pivot value in the proper position
        swapReferences(array, left, border - 1);
        // return the index of the pivot
        return border - 1;
    }

}
