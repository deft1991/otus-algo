package com.deft.otus.homework6;

import com.deft.otus.homework5.sort.ISort;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/30/20
 */
public class RadixSort implements IntSort, ISort {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr = {300, 100, 200, 3, 2, 1, 30, 10, 20};
        radixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    @Override
    public Consumer<int[]> sort() {
        return this::sort;
    }

    @Override
    public void sort(int[] arr) {

        int length = arr.length;
        int max = getMax(arr, length);

        for (int radix = 1; radix < max; radix *= 10) {
            radixSort(arr, length, radix);
        }

    }

    private void radixSort(int[] arr, int length, int radix) {
        int[] output = new int[length]; // output array
        int[] count = new int[10];
        Arrays.fill(count, 0);

        fillCount(arr, length, count, radix);
        migrateToIndex(count);
        fillOutput(arr, length, output, count, radix);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    private void fillOutput(int[] arr, int length, int[] output, int[] count, int radix) {
        for (int i = length - 1 ; i >= 0 ; i--) {
            int digit = (arr[i] / radix) % 10;
            output[--count[digit]] = arr[i];
        }
    }

    private void migrateToIndex(int[] count) {
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    }

    private void fillCount(int[] arr, int length, int[] count, int radix) {
        for (int i = 0; i < length; i++) {
            int digit = (arr[i] / radix) % 10;
            count[digit]++;
        }
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
}
