package com.deft.otus.homework6;

import com.deft.otus.homework5.sort.ISort;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/28/20
 */
public class QuickSort implements IntSort, ISort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
//        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        int[] arr = {10, 4, 3, 7, 6, 1, 5};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public Consumer<int[]> sort() {
        return this::sort;
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int a = partition(arr, left, right);

        quickSort(arr, left, a - 1);
        quickSort(arr, a + 1, right);

    }

    /**
     * 10, 4, 3, 7, 6, 1, 5
     *
     * left 10 right 5
     * pivot 5
     * a -1
     *
     * 10 < 5
     * i++
     *
     * 4 < 5
     * swap(10, 4)
     * 4, 10, 3, 7, 6, 1, 5
     * i++
     * 3 < 5
     * swap (10, 3)
     * 4, 3, 10, 7, 6, 1, 5
     * 7 < 5
     * i++
     * 6 < 5
     * i++
     * 1 < 5
     * swap(10, 1)
     * 4, 3, 1, 7, 6, 10, 5
     * 5<=5
     * swap(7,5)
     * 4, 3, 1, 5, 6, 10, 7
     */
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int a = left - 1;

        for (int i = left; i <= right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, ++a, i);
            }
        }
        return a;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
