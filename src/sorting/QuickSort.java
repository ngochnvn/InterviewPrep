package sorting;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start <= end) {
            int i = partition(arr, start, end);
            sort(arr, i+1, end);
            sort(arr, start, i - 1);
        }
    }

    /**
     * partition arr into two parts using the end as the pivot
     *
     * Return index such that:
     * - item before index is smaller than pivot value
     * - item after index is larger than pivot value
     *
     * the overall goal is to move all item smaller than pivot to the left.
     * Set i = start - 1
     * Iterate through array index j from start to end-1:
     * - increment i as we find item smaller and swap with j
     *
     * from start -> i will be item smaller than pivot, thus swap between i+1 and end
     */
    private int partition(int[] arr, int start, int end) { //start=0, end =6, arr = 1, 5, 4, 2, 1, 7, 9
        int pivotVal = arr[end]; // 7
        int i = start - 1; //4
        for (int j = start; j < end; j++) { // j = 6
            if (arr[j] <= pivotVal) { //arr[j] = 1
                i++;
                swap(arr, i, j); //swap 4 5
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{10,9,8,7,6,5,5,4,3};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
