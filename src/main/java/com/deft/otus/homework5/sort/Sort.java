package com.deft.otus.homework5.sort;

import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class Sort {

    public void sort(Consumer<int[]> sortAlgorithm, String algorithmName , int[] array) {
        long start = System.currentTimeMillis();
        sortAlgorithm.accept(array);
        long end = System.currentTimeMillis();
        System.out.printf("Execution time of %s is %d \n", algorithmName, end - start);
    }
}
