package com.deft.otus.homework11;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class PrimaAlgo implements SpanningTree {
    private final Edge[][] adjacencyVector;
    private final List<Edge> spanningTree;
    private final boolean[] usedVertex;
    private final int vertexCount;

    public PrimaAlgo(Edge[][] adjacencyVector) {
        this.adjacencyVector = adjacencyVector;
        this.vertexCount = adjacencyVector.length;
        usedVertex = new boolean[vertexCount];
        spanningTree = new ArrayList<>();
    }

    @Override
    public Edge[] getSpanningTree() {
        return getSpanningTree(0);
    }

    public Edge[] getSpanningTree(int idx) {
        usedVertex[idx] = true;
        while (spanningTree.size() < vertexCount - 1) {
            Edge minUnusedWeightEdge = getMinUnusedWeightEdge();
            if (minUnusedWeightEdge.vertexOne != minUnusedWeightEdge.vertexTwo) {
                spanningTree.add(minUnusedWeightEdge);
            }
        }
        return spanningTree.toArray(new Edge[0]);
    }

    private Edge getMinUnusedWeightEdge() {
        int edgeIdx = 0;
        // что бы составить пару из -- к
        int vertexIdx = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < vertexCount - 1; i++) {
            // если эта вершина в списке открытых вершин
            if (usedVertex[i]) {
                // ребра из доступной вершины
                Edge[] edges = adjacencyVector[i];
                // ищем минимальное ребро
                for (int j = 0; j < edges.length; j++) {
                    if (edges[j] != null) {

                        // если значение минимальное
                        // и
                        // данная вершина еще не использовалась
                        // тогда мы можем ее использовать
                        if (edges[j].weight < minValue && !usedVertex[edges[j].vertexTwo]) {
                            vertexIdx = i;
                            edgeIdx = edges[j].vertexTwo;
                            minValue = edges[j].weight;
                        }
                    }
                }
            }

        }
        usedVertex[edgeIdx] = true;
        return new Edge(vertexIdx, edgeIdx, minValue);
    }
}
