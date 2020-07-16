package com.deft.otus.homework12;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class Tester {

    private static final Edge[][] adjacencyVectorEdgeWithWeight = {
            {new Edge(1, 7), new Edge(2, 9), new Edge(5, 14), null},
            {new Edge(0, 7), new Edge(2, 10), new Edge(3, 15), null},
            {new Edge(0, 9), new Edge(1, 10), new Edge(3, 11), new Edge(5, 2)},
            {new Edge(1, 15), new Edge(2, 11), new Edge(4, 6), null},
            {new Edge(3, 6), new Edge(5, 9), null, null},
            {new Edge(0, 14), new Edge(2, 2), new Edge(4, 9), null},
    };


    public static void main(String[] args) {

        DijkstraAlgo dijkstraAlgo = new DijkstraAlgo(adjacencyVectorEdgeWithWeight);
        dijkstraAlgo.dijkstaAlgo(0, 4);
        System.out.println();
    }
}
