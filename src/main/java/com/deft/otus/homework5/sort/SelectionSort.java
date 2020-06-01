package com.deft.otus.homework5.sort;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class SelectionSort implements ISort {

    public static void main(String[] args) {
        int[] ints = {4, 3, 2, 7, 8};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort().accept(ints);
        System.out.println(Arrays.toString(ints));
    }

    public Consumer<int[]> sort() {
        return (arr) -> {
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                int x = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > x) {
                    arr[j + 1] = arr[j];

                    j--;
                }
                arr[j + 1] = x;
            }
        };
    }
}
