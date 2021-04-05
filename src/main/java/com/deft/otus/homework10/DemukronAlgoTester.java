package com.deft.otus.homework10;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 7/7/20
 */
public class DemukronAlgoTester {

    public static void main(String[] args) {
        DemukronAlgo demukronAlgo = new DemukronAlgo();
        firstTest(demukronAlgo);
        System.out.println("-=-=-=-=-=-=");
        secondTest(demukronAlgo);

    }

    private static void secondTest(DemukronAlgo demukronAlgo) {
        int[][] adjacencyMatrixCorrect = {
              // 1  2  3  4  5  6  7  8  9  10 11 12 13 14
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 1
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 2
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 3
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 4
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}, // 5
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}, // 6
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, // 7
                {0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, // 8
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, // 9
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0}, // 10
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 11
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 12
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 13
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // 14
        };

        System.out.println();
        Integer[][] rez = demukronAlgo.topologySort(adjacencyMatrixCorrect, false);

        Arrays.stream(rez).forEach(layer -> System.out.println(Arrays.toString(layer)));
    }

    private static void firstTest(DemukronAlgo demukronAlgo) {

        int[][] adjacencyVectorCorrect = {
                {1, 2, 3, 0, 0},
                {2, 0, 0, 0, 0},
                {3, 0, 0, 0, 0},
                {4, 1, 3, 5, 0},
                {5, 2, 0, 0, 0}
        };

        System.out.println();
        Integer[][] rez = demukronAlgo.topologySort(adjacencyVectorCorrect, true);

        Arrays.stream(rez).forEach(layer -> System.out.println(Arrays.toString(layer)));
    }
}
