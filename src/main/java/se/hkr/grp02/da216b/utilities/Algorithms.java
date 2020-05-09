package se.hkr.grp02.da216b.utilities;


import se.hkr.grp02.da216b.algorithms.heapSort.HeapSortRecursive;
import se.hkr.grp02.da216b.algorithms.mergeSort.MergeSortRecursive;
import se.hkr.grp02.da216b.algorithms.quickSort.QuickSortRecursiveFP;
import se.hkr.grp02.da216b.algorithms.shellSort.ShellSort;

public class Algorithms {
    private HeapSortRecursive heapSort;
    private MergeSortRecursive mergeSort;
    private QuickSortRecursiveFP quickSort;
    private ShellSort shellSort;

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
    public Algorithms(ShellSort shellSort) {
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
    public Algorithms(HeapSortRecursive heapSort, ShellSort shellSort) {
        this.heapSort = heapSort;
        this.shellSort = shellSort;
    }
    //                   MergeSort
    public Algorithms(MergeSortRecursive mergeSort, QuickSortRecursiveFP quickSort) {
        this.mergeSort = mergeSort;
        this.quickSort = quickSort;
    }
    public Algorithms(MergeSortRecursive mergeSort, ShellSort shellSort) {
        this.mergeSort = mergeSort;
        this.shellSort = shellSort;
    }
    //                   QuickSort
    public Algorithms(QuickSortRecursiveFP quickSort, ShellSort shellSort) {
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
    public Algorithms(HeapSortRecursive heapSort, MergeSortRecursive mergeSort, ShellSort shellSort) {
        this.heapSort = heapSort;
        this.mergeSort = mergeSort;
        this.shellSort = shellSort;
    }
    public Algorithms(HeapSortRecursive heapSort, QuickSortRecursiveFP quickSort, ShellSort shellSort) {
        this.heapSort = heapSort;
        this.quickSort = quickSort;
        this.shellSort = shellSort;
    }
    //                   MergeSort
    public Algorithms(MergeSortRecursive mergeSort, QuickSortRecursiveFP quickSort, ShellSort shellSort) {
        this.mergeSort = mergeSort;
        this.quickSort = quickSort;
        this.shellSort = shellSort;
    }

    //combinations of 4
    public Algorithms(HeapSortRecursive heapSort, MergeSortRecursive mergeSort, QuickSortRecursiveFP quickSort, ShellSort shellSort) {
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

    public ShellSort getShellSort() {
        return shellSort;
    }
}
