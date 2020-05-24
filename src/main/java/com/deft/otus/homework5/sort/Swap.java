package com.deft.otus.homework5.sort;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class Swap {

    public static void swap(Object[] arr, int firstIdx, int secondIdx) {
        Object tmp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = tmp;
    }

    public static void swap(int[] arr, int firstIdx, int secondIdx) {
        int tmp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = tmp;
    }
}
