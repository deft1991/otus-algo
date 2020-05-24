package com.deft.otus.homework5.sort;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class ShellSort {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] ints = {4, 3, 2, 8, 7, 1, 5};
        shellSort.sort(shellSort.shellSortHalf(), "shellSortHalf",ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{4, 3, 2, 8, 7, 1, 5};
        shellSort.sort(shellSort.shellSortHibbardCoefficient(), "shellSortHibbardCoefficient",ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{4, 3, 2, 8, 7, 1, 5};
        shellSort.sort(shellSort.shellSortKnuthCoefficient(), "shellSortKnuthCoefficient",ints);
        System.out.println(Arrays.toString(ints));

    }

    void sort(Consumer<int[]> sortAlgorithm, String algorithmName ,int[] array) {
        long start = System.currentTimeMillis();
        sortAlgorithm.accept(array);
        long end = System.currentTimeMillis();
        System.out.printf("Execution time of %s is %d", algorithmName, end - start);
    }

    public Consumer<int[]> shellSortHalf() {
        return (arr) -> {
            int length = arr.length;
            for (int gap = length / 2; gap > 0; gap /= 2) {
                sortWithGap(arr, length, gap);
            }
        };
    }

    public Consumer<int[]> shellSortHibbardCoefficient() {
        return (arr) -> {
            int length = arr.length;
            for (int k = 7; k >= 0; k--) {
                int gap = (int) (Math.pow(2, k) - 1);
                sortWithGap(arr, length, gap);
            }
        };
    }

    public Consumer<int[]> shellSortKnuthCoefficient() {
        return (arr) -> {
            int length = arr.length;

            for (int k = 13; k >= 0; k--) {
                int gap = (int) (Math.pow(3, k) - 1) / 2;
                sortWithGap(arr, length, gap);
            }
        };
    }

    private void sortWithGap(int[] arr, int length, int gap) {
        for (int i = 0; i < length; i++) {
            int x = arr[i];
            int j = i - gap;

            while (j >= 0 && arr[j] > x) {
                arr[j + gap] = arr[j];
                j -= gap;
            }
            arr[j + gap] = x;
        }
    }
}
