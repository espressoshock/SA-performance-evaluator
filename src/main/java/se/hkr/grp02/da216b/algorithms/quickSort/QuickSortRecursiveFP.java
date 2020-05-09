package se.hkr.grp02.da216b.algorithms.quickSort;

/**
 * QUICKSORT - RECURSIVE IMPL. MEDIAN-OF-THREE.
 *
 * Is a DIVIDE AND CONQUER algorithm.
 * It is NOT STABLE.
 * It is IN-PLACE.
 * Overall time complexity: Average case O(NlogN); Worst case O(N^2)
 *
 * Implementation :
 *
 * 1. Find  a pivot(In this implementation is used 'median-of-three')
 *
 * 2. Move pivot at the beginning of the collection.
 *
 * 3. Set pointer next left from pivot.
 *
 * 4. Compare to the right all the elements. If smaller than pivot, swap with the pointer.
 *
 * 5. Increase pointer with one and repeat step 4 until the right end is reached.
 *
 * 6. Swap the pivot with the last smaller element indicated by the '--pointer' index.
 *
 * 6. Create two partitions. One before pivot; another after pivot.
 *
 * 7. Make recursive calls for both partitions, until their size equals 1.
 */
public class QuickSortRecursiveFP {

    public String getNAME() {
        return "quick";
    }

    /**
     * It is used to call the recursive quick sort and
     * return the sorted array
     * @param workload collection to be sorted
     * @param <E> type
     * @return sorted collection
     */
    public <E extends Comparable<? super E>> E[] sort(E[] workload) {
        // start the sort with the entire list
        quickSort(workload, 0, workload.length - 1);
        return workload;
    }

    /**
     * Selects the median-of-three pivot to create
     * partitions(as long as their size is larger than 1)
     * and to make recursive calls for each
     *
     * @param array the list
     * @param from  pointer to the start
     * @param to    pointer to the end
     * @param <E>   type
     */
    private static <E extends Comparable<? super E>> void quickSort(E[] array, int from, int to) {
        //if there is more than one element of the array to be sorted
        if (from < to + 1) {
            // find the median-of-three pivot
            int pivotIndex = partition(array, from, to);

            // recursive call for the left partition
            quickSort(array, from, pivotIndex - 1);

            // recursive call for the right partition
            quickSort(array, pivotIndex + 1, to);
        }
        // else, the collection is already sorted
    }

    /**
     * USING MEDIAN PIVOT
     * goes through each value and compares it to the pivot value
     * and swaps smaller elements to the left of the pivot
     *
     * @param array input
     * @param left  start from
     * @param right up to
     * @param <E>   elements type
     * @return the index value of the pivot
     */
    private static <E extends Comparable<? super E>> int partition(E[] array, int left, int right) {
       median3Pivot(array, left, right);
        //start comparing from next element after pivot
        int pointer = left + 1;
        for (int i = pointer; i <= right; i++) {
            // if the compared element is smaller than the pivot, swap it with the pointer value
            if (array[i].compareTo(array[left]) < 0) {
                // pointer is pointing to the next position to fill with smaller than pivot
                // pointer++ will point to the next available index
                swapReferences(array, i, pointer++);
            }
        }
        // pointer shows the first larger than the pivot
        // --pointer is the last smaller than the pivot
        swapReferences(array, left, --pointer);
        // return the index of the pivot
        return pointer;
    }

    /**
     * Compares the first element, the last,
     * and one in the middle of
     * the collection; move the middle value
     * at the left end of the sorting space.
     * @param array input
     * @param left first index
     * @param right last index
     * @param <E> type
     */
    private static <E extends Comparable<? super E>> void median3Pivot(E[] array, int left, int right) {
        if (left < right + 2) {
            // find the center
            int center = (right + left) / 2;
            // compare left to middle
            if (array[left].compareTo(array[center]) > 0) {
                swapReferences(array, left, center);
            }
            //compare left to right
            if (array[left].compareTo(array[right]) > 0) {
                swapReferences(array, left, right);
            }
            //compare middle with right
            if (array[center].compareTo(array[right]) > 0) {
                swapReferences(array, center, right);
            }
            // at this point the middle value is at the 'center' index
            // move pivot at the beginning of the sorting space
            swapReferences(array, left, center);
        }
    }

    /**
     * Swap element at index 'a'
     * with the one at index 'b'
     *
     * @param array input
     * @param a     element to swap
     * @param b     element to swap
     * @param <E>   the type of elements
     */
    private static <E> void swapReferences(E[] array, int a, int b) {
        // a temporary E instance is used to store first element
        E temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
