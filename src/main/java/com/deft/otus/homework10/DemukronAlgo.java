package com.deft.otus.homework10;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 7/6/20
 */
public class DemukronAlgo {


    public Integer[][] topologySort(int[][] matrix, boolean isAdjacencyVector) {
        if (isAdjacencyVector) {
            int[][] adjacencyMatrix = convertToAdjacencyMatrix(matrix);
            return demukronAlgo(adjacencyMatrix);
        }
        return demukronAlgo(matrix);
    }

    /**
     * AdjacencyVector
     * 1  --  2
     * /\    / |
     * 3 - 4 - 5
     * <p>
     * <p>
     * 1 | 2 3 4 0
     * 2 | 1 4 5 0
     * 3 | 1 4 0 0
     * 4 | 1 2 3 5
     * 5 | 2 4 0 0
     * <p>
     * TO
     * <p>
     * AdjacencyMatrix
     * 1	--	2
     * /\    / |
     * 3 - 4 - 5
     * <p>
     * ....1 2 3 4 5
     * ....---------
     * 1 | 0 1 1 1 0
     * 2 | 1 0 0 1 1
     * 3 | 1 0 0 1 0
     * 4 | 1 1 1 0 1
     * 5 | 0 1 0 1 0 smth like this
     *
     * @param adjacencyVector - vector for convert
     * @return adjacencyMatrix
     */
    private int[][] convertToAdjacencyMatrix(int[][] adjacencyVector) {
        int length = adjacencyVector.length;

        int[][] adjacencyMatrix = new int[length][length];

        for (int i = 0; i < length; i++) {
            int[] edgeArches = adjacencyVector[i];

            for (int endEdge : edgeArches) {
                if (endEdge == 0 || i == endEdge - 1) {
                    continue;
                }
                adjacencyMatrix[i][endEdge - 1]++;

            }
        }
        return adjacencyMatrix;
    }

    private Integer[][] demukronAlgo(int[][] adjacencyMatrix) {
        List<List<Integer>> rez = new ArrayList<>();
        int layerLvl = 0;
        boolean isFinished = false;
        int[] inputEdgeCount = calculateInputEdgeCount(adjacencyMatrix);
        int[] tmpInputEdgeCount = new int[inputEdgeCount.length];
        System.arraycopy(inputEdgeCount, 0, tmpInputEdgeCount, 0, inputEdgeCount.length);

        while (!isFinished) {
            rez.add(new ArrayList<>());
            for (int i = 0; i < inputEdgeCount.length; i++) {
                if (inputEdgeCount[i] == 0) {
                    rez.get(layerLvl).add(i);
                    minusZeroLines(tmpInputEdgeCount, adjacencyMatrix, i);
                }
            }
            // swap temp and current edge count
            System.arraycopy(tmpInputEdgeCount, 0, inputEdgeCount, 0, inputEdgeCount.length);
            layerLvl++;
            isFinished = checkIsFinished(inputEdgeCount);
        }
        return convertResultToArray(rez);
    }

    private Integer[][] convertResultToArray(List<List<Integer>> rez) {
        return rez.stream().map(l -> l.toArray(new Integer[0])).toArray(Integer[][]::new);
    }

    /**
     * minus zero lines from input edges array
     *
     * @param tmpInputEdgeCount - edge count array
     * @param adjacencyMatrix   - base matrix
     * @param i                 - line number
     */
    private void minusZeroLines(int[] tmpInputEdgeCount, int[][] adjacencyMatrix, int i) {
        for (int j = 0; j < tmpInputEdgeCount.length; j++) {
            tmpInputEdgeCount[j] -= adjacencyMatrix[i][j];
        }
        tmpInputEdgeCount[i] = -1;
    }

    /**
     * if all elements less then 0 we check all edges
     *
     * @param inputEdgeCount - count input line
     * @return is finished
     */
    private boolean checkIsFinished(int[] inputEdgeCount) {
        for (int el : inputEdgeCount) {
            if (el >= 0) {
                return false;
            }
        }
        return true;
    }

    private int[] calculateInputEdgeCount(int[][] adjacencyMatrix) {
        int length = adjacencyMatrix.length;
        int[] inputEdgeCount = new int[length];

        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int[] matrix : adjacencyMatrix) {
                count += matrix[i];

            }
            inputEdgeCount[i] = count;
        }

        return inputEdgeCount;
    }
}
