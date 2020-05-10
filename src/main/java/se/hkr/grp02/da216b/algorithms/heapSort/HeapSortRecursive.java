package se.hkr.grp02.da216b.algorithms.heapSort;


/**
 * https://big-o.io/examples/heapsort/java-generic/
 *
 * Modified by Nemanja Negovanovic
 * Heap Sort - Generic - Recursive
 * @param <E> - Any comparable element type
 */

public class HeapSortRecursive<E extends Comparable<? super E>> {
    ///////******** =IMPORTED ///////********
    private final static String NAME = "heap"; //-> updated to static
//    public int[] sort(int[] workload) {
//        return workload;
//    }
//    public String[] sort(String[] workload) {
//        return workload;
//    }
    public String getNAME() {
        return "heap";
    }
    ///////******** =IMPORTED ///////********
    public E[] sort(E[] array)
    {
        E[] sortedArray = array;
        int size = sortedArray.length;

        for (int i = size / 2 - 1; i >= 0; i--)// build minHeap
            heapify(sortedArray, size, i);

        for (int i = size - 1; i >= 0; i--)// extract element
        {
            E temp = sortedArray[0]; // move current root to end
            sortedArray[0] = sortedArray[i];
            sortedArray[i] = temp;

            heapify(sortedArray, i, 0);
        }
        return sortedArray;
    }


    void heapify(E[] array, int size, int i)
    {
        int max   = i; // initialize max as root
        int left  = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger than root
        if (left < size && array[left].compareTo(array[max]) > 0)
            max = left;

        // if right child is larger than max
        if (right < size && array[right].compareTo(array[max]) > 0)
            max = right;

        if (max != i)
        {
            E temp = array[i]; // swap
            array[i] = array[max];
            array[max] = temp;

            heapify(array, size, max);
        }
    }
}
