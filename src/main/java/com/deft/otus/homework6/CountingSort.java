package com.deft.otus.homework6;

import com.deft.otus.homework5.sort.ISort;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/30/20
 */
public class CountingSort implements IntSort, ISort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 7, 5, 6, 4, 2, 9, 8, 5, 2, 4, 1, 0, 8, 3, 6, 4};
        IntSort intSort = new CountingSort();
        intSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public Consumer<int[]> sort() {
        return this::sort;
    }

    @Override
    public void sort(int[] arr) {
        countingSort(arr, 999999);
    }


    private void countingSort(int[] arr, int range) {
        int[] tmpArr = new int[range];
        int[] rez = new int[arr.length];

        for (Integer val : arr) {
            tmpArr[val]++;
        }

        for (int i = 1; i < tmpArr.length; i++) {
            tmpArr[i] += tmpArr[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int baseVal = arr[i];
            int idx = --tmpArr[baseVal];
            rez[idx] = baseVal;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rez[i];
        }
    }
}
