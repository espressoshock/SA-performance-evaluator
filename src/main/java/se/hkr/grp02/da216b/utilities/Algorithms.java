package se.hkr.grp02.da216b.utilities;


import se.hkr.grp02.da216b.algorithms.heapSort.HeapSortRecursive;
import se.hkr.grp02.da216b.algorithms.mergeSort.MergeSortRecursive;
import se.hkr.grp02.da216b.algorithms.quickSort.QuickSortRecursiveFP;
import se.hkr.grp02.da216b.algorithms.shellSort.ShellSortRecursive;

public class Algorithms {
    private HeapSortRecursive heapSort;
    private MergeSortRecursive mergeSort;
    private QuickSortRecursiveFP quickSort;
    private ShellSortRecursive shellSort;

    //combinations of 1
    public Algorithms(HeapSortRecursive heapSort) {
        this.heapSort = heapSort;
    }

    public Algorithms(MergeSortRecursive mergeSort) {
        this.mergeSort = mergeSort;
    }

    public Algorithms(QuickSortRecursiveFP quickSort) {
        this.quickSort = quickSort;
    }
    public Algorithms(ShellSortRecursive shellSort) {
        this.shellSort = shellSort;
    }

    //combinations of 2
    //                   HeapSort
    public Algorithms(HeapSortRecursive heapSort, MergeSortRecursive mergeSort) {
        this.heapSort = heapSort;
        this.mergeSort = mergeSort;
    }
    public Algorithms(HeapSortRecursive heapSort, QuickSortRecursiveFP quickSort) {
        this.heapSort = heapSort;
        this.quickSort = quickSort;
    }
    public Algorithms(HeapSortRecursive heapSort, ShellSortRecursive shellSort) {
        this.heapSort = heapSort;
        this.shellSort = shellSort;
    }
    //                   MergeSort
    public Algorithms(MergeSortRecursive mergeSort, QuickSortRecursiveFP quickSort) {
        this.mergeSort = mergeSort;
        this.quickSort = quickSort;
    }
    public Algorithms(MergeSortRecursive mergeSort, ShellSortRecursive shellSort) {
        this.mergeSort = mergeSort;
        this.shellSort = shellSort;
    }
    //                   QuickSort
    public Algorithms(QuickSortRecursiveFP quickSort, ShellSortRecursive shellSort) {
        this.quickSort = quickSort;
        this.shellSort = shellSort;
    }

    //combinations of 3
    //                   HeapSort
    public Algorithms(HeapSortRecursive heapSort, MergeSortRecursive mergeSort, QuickSortRecursiveFP quickSort) {
        this.heapSort = heapSort;
        this.mergeSort = mergeSort;
        this.quickSort = quickSort;
    }
    public Algorithms(HeapSortRecursive heapSort, MergeSortRecursive mergeSort, ShellSortRecursive shellSort) {
        this.heapSort = heapSort;
        this.mergeSort = mergeSort;
        this.shellSort = shellSort;
    }
    public Algorithms(HeapSortRecursive heapSort, QuickSortRecursiveFP quickSort, ShellSortRecursive shellSort) {
        this.heapSort = heapSort;
        this.quickSort = quickSort;
        this.shellSort = shellSort;
    }
    //                   MergeSort
    public Algorithms(MergeSortRecursive mergeSort, QuickSortRecursiveFP quickSort, ShellSortRecursive shellSort) {
        this.mergeSort = mergeSort;
        this.quickSort = quickSort;
        this.shellSort = shellSort;
    }

    //combinations of 4
    public Algorithms(HeapSortRecursive heapSort, MergeSortRecursive mergeSort, QuickSortRecursiveFP quickSort, ShellSortRecursive shellSort) {
        this.heapSort = heapSort;
        this.mergeSort = mergeSort;
        this.quickSort = quickSort;
        this.shellSort = shellSort;
    }

    public HeapSortRecursive getHeapSort() {
        return heapSort;
    }

    public MergeSortRecursive getMergeSort() {
        return mergeSort;
    }

    public QuickSortRecursiveFP getQuickSort() {
        return quickSort;
    }

    public ShellSortRecursive getShellSort() {
        return shellSort;
    }
}
