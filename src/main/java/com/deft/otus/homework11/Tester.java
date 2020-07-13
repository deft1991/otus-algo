package com.deft.otus.homework11;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class Tester {

    private static final Integer[][] adjacencyVector = {
            {1, 3, null, null, null},
            {0, 2, 3, 4, null},
            {1, 4, null, null, null},
            {0, 1, 4, 5, null},
            {1, 2, 3, 5, 6},
            {3, 4, 6, 0, 0},
            {4, 5, 0, 0, 0}
    };

    private static final Integer[][] adjacencyVectorWithWeight = {
            {7, 5, null, null, null},
            {7, 8, 9, 7, null},
            {8, 5, null, null, null},
            {5, 9, 15, 6, null},
            {7, 5, 15, 8, 9},
            {6, 8, 11, 0, 0},
            {11, 9, 0, 0, 0}
    };


    private static final Edge[][] adjacencyVectorEdgeWithWeight = {
            {new Edge(1, 7), new Edge(3, 5), null, null, null},
            {new Edge(0, 7), new Edge(2, 8), new Edge(3, 9), new Edge(4, 7), null},
            {new Edge(1, 8), new Edge(4, 5), null, null, null},
            {new Edge(0, 5), new Edge(1, 9), new Edge(4, 15), new Edge(5, 6), null},
            {new Edge(1, 7), new Edge(2, 5), new Edge(3, 15), new Edge(5, 8), new Edge(6, 9)},
            {new Edge(3, 6), new Edge(4, 8), new Edge(6, 11), null, null},
            {new Edge(4, 11), new Edge(5, 9), null, null}
    };


    public static void main(String[] args) {
        PrimaAlgo primaAlgo = new PrimaAlgo(adjacencyVectorEdgeWithWeight);
        Edge[] spanningTree = primaAlgo.getSpanningTree(0);
        System.out.println();
    }
}
