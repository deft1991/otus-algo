package com.deft.otus.homework6;

import com.deft.otus.homework5.sort.ISort;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/28/20
 */
public class MergeSort implements IntSort, ISort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {8, 3, 6, 2, 1, 0, 5, 4,7, 9};
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    @Override
    public Consumer<int[]> sort() {
        return this::sort;
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int[] rez = new int[right - left + 1];
        int aRun = left;
        int bRun = mid + 1;
        int writer = 0;
        while (aRun <= mid && bRun <= right) {
            if (arr[aRun] < arr[bRun]) {
                rez[writer] = arr[aRun];
                aRun++;
            } else {
                rez[writer] = arr[bRun];
                bRun++;
            }
            writer++;
        }

        while (aRun <= mid) {
            rez[writer] = arr[aRun];
            aRun++;
            writer++;
        }

        while (bRun <= right) {
            rez[writer] = arr[bRun];
            bRun++;
            writer++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = rez[i - left];
        }
    }
}
