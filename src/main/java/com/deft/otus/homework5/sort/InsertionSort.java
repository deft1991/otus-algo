package com.deft.otus.homework5.sort;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.deft.otus.homework5.sort.Swap.swap;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class InsertionSort implements ISort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] ints = {1, 3, 2, 4, 6, 5, 7, 8, 9, 0};
        insertionSort.sort().accept(ints);
        System.out.println(Arrays.toString(ints));

    }

    public Consumer<int[]> sort() {
        return (arr) -> {
            int arrLength = arr.length;
            for (int i = 0; i < arrLength; i++) {

                int minElIdx = i;

                for (int j = i; j < arrLength; j++) {

                    if (arr[j] < arr[minElIdx]) {
                        minElIdx = j;
                    }
                }
                swap(arr, minElIdx, i);
            }
        };
    }
}
