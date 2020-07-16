package com.deft.otus.homework12;

import java.util.LinkedList;

/*
 * Created by sgolitsyn on 7/16/20
 */
public class DijkstraAlgo {

    private final Edge[][] adjacencyVectorEdgeWithWeight;
    private final int length;


    public DijkstraAlgo(Edge[][] adjacencyVectorEdgeWithWeight) {
        this.adjacencyVectorEdgeWithWeight = adjacencyVectorEdgeWithWeight;
        this.length = adjacencyVectorEdgeWithWeight.length;
    }


    public Edge[] dijkstaAlgo(int from, int to) {
        int[] wayWeight = new int[length];
        int[] edgeWay = new int[length];
        boolean[] isUsed = new boolean[length];
        int usedCount = 0;

        for (int i = 0; i < length; i++) {
            wayWeight[i] = Integer.MAX_VALUE;
            isUsed[i] = false;
        }
        wayWeight[from] = 0;

        while (usedCount < length) {
            int v = getMinIdx(wayWeight, isUsed);

            Edge[] vEdges = adjacencyVectorEdgeWithWeight[v];

            for (Edge edgeTo : vEdges) {
                if (edgeTo != null && !isUsed[edgeTo.To]) {
                    int sumWeights = wayWeight[v] + edgeTo.weight;
                    if (sumWeights < wayWeight[edgeTo.To]) {
                        wayWeight[edgeTo.To] = sumWeights;
                        edgeWay[edgeTo.To] = v;
                    }
                }
            }
            usedCount++;
            isUsed[v] = true;
        }

        LinkedList<Edge> edges = prepareResult(to, edgeWay);

        return edges.toArray(new Edge[0]);
    }

    private LinkedList<Edge> prepareResult(int to, int[] edgeWay) {
        LinkedList<Edge> rez = new LinkedList<>();
        while (to != edgeWay[to]) {
            int finalTo = to;
            var edge = new Edge();
            edge.From = edgeWay[finalTo];
            edge.To = finalTo;

            rez.addFirst(edge);
            to = edgeWay[to];
        }
        return rez;
    }

    private int getMinIdx(int[] wayWeight, boolean[] isUsed) {
        int minVal = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i = 0; i < wayWeight.length; i++) {
            if (!isUsed[i] && wayWeight[i] < minVal) {
                minVal = wayWeight[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

}
