package se.hkr.grp02.da216b.algorithms.mergeSort;

import java.util.Arrays;

/***
 * MERGESORT - RECURSIVE IMPL.
 */
public class MergeSortRecursive {

    private final String NAME = "merge";

    /**
     * Takes a collection that implements Comparable
     * and sorts it by calling the recursive Merge sort
     * @param workload collection to be sorted
     *                 implements Comparable
     * @param <E> Collection's type
     * @return The sorted collection
     */
    public <E extends Comparable<? super E>> E[] sort(E[] workload){
        // sort the collection
        sortRecursive(workload, 0, workload.length - 1);
        // return collection
        return workload;
    }

    /**
     * Create two halves from the initial collection
     * using the segment between 'from', 'median', and 'to'
     * Compares the corresponding elements of the two halves
     * and merge them back into the initial collection,
     * sorted in natural order
     * @param workload the initial collection
     * @param from index of the beginning of the left half
     *             in the initial collection
     * @param median index of the (end + 1) of the first half
     *               in the initial collection
     * @param to index of the end of the second half
     *           in the initial collection
     * @param <E> collection's type
     */
    public <E extends Comparable<? super E>> void merge(E[] workload, int from, int median, int to) {
        // Find sizes of two sub arrays to be merged
        int leftLength = median - from + 1;
        int rightLength = to - median;

        // Create halves Left ( leftSide ) & Right ( rightSide )
        E[] leftSide = Arrays.copyOfRange(workload, 0, leftLength);
        E[] rightSide = Arrays.copyOfRange(workload, 0, rightLength);

        // Split workload in halves
        System.arraycopy(workload, from ,leftSide, 0, leftLength);
        System.arraycopy(workload, median + 1, rightSide, 0, rightLength);

        // merge back the two halves, sorting them
       mergeHalves(workload, leftSide, rightSide,from);
    }

    /**
     * Take a two segments of the same collection, merge them back sorting them
     * @param workload the initial collection
     * @param left left half of the segment in the collection
     * @param right right half of the segment in the collection
     * @param from index for left[0] in the initial collection
     * @param <E> Collection's type
     */
    public <E extends Comparable<? super E>> void mergeHalves(E[] workload, E[] left, E[] right, int from){
        // Compare&merge elements of the two halves
        // indexes for halves
        int i = 0, j = 0;

        // Initial index of merged sub array
        int k = from;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 1 ){
                workload[k] = left[i];
                i++;
            } else {
                workload[k] = right[j];
                j++;
            }
            k++;
        }
        // indexes value when one half is sorted/added already
        int[] indexes = {i, j, k};
        // add the elements of the half with remained elements
        addLargerRemaining(workload, left, right, indexes);
    }

    /**
     * After elements in one collection are exhausted,
     * if are any left in the other one, add them at
     * the end considering them being sorted
     * @param workload initial collection
     * @param left left side of the segment
     * @param right right side of the segment
     * @param indexes collection of indexes in the halves and the initial collection
     * @param <E> Collection's type
     */
    public <E extends Comparable<? super E>> void addLargerRemaining(E[] workload, E[] left, E[] right, int[] indexes){
        // Copy remaining bigger already sorted
        // elements of left[]
        while (indexes[0] < left.length) {
            workload[indexes[2]] = left[indexes[0]];
            indexes[0]++;
            indexes[2]++;
        }
        // Copy remaining bigger already sorted
        // elements of right[]
        while (indexes[1] < right.length) {
            workload[indexes[2]] = right[indexes[1]];
            indexes[1]++;
            indexes[2]++;
        }
    }

    /**
     * base case : size larger than 1 (fromLeft < toRight)
     * until the base case is reached, divide in half
     * and merge the two sorted halves back
     *
     * @param workload the collection to be sorted
     * @param fromLeft the index in the initial workload
     *                of the beginning of the new left half
     * @param toRight the index in the initial workload
     *      *         of the beginning of the new right half
     * @param <E> collection's type
     */
    public <E extends Comparable<? super E>> void sortRecursive (E[] workload, int fromLeft, int toRight) {
        // base case size > 1
        if (fromLeft < toRight) {
            // Find the middle point
            int middlePoint = (fromLeft + toRight) / 2;

            // Sort first and second halves
            sortRecursive(workload, fromLeft, middlePoint);
            sortRecursive(workload, middlePoint + 1, toRight);

            // Merge the sorted halves
            merge(workload, fromLeft, middlePoint, toRight);
        }
    }

    /**
     * returns the name of the algorithm
     * @return string value
     */
    public String getNAME() {
        return NAME;
    }
}
