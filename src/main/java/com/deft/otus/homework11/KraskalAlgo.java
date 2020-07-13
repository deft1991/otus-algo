package com.deft.otus.homework11;

import com.deft.otus.homework11.minHeap.MinHeapForEdge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class KraskalAlgo implements SpanningTree {

    private final Edge[][] adjacencyVector;
    private final int vertexesSize;
    private final int[] vertexes;

    public KraskalAlgo(Edge[][] adjacencyVector) {
        this.adjacencyVector = adjacencyVector;
        vertexesSize = adjacencyVector.length;
        vertexes = new int[vertexesSize];
        for (int i = 0; i < vertexesSize; i++) {
            vertexes[i] = i;
        }
    }

    @Override
    public Edge[] getSpanningTree() {
        return kraskalAlgo();
    }

    private Edge[] kraskalAlgo() {
        Edge[] rez = new Edge[vertexesSize - 1];
        int curIdx = 0;
//        ребра.Отсортировать(G(E))
        MinHeapForEdge minHeapForEdge = fillMinHeap();
//        для m из ребра
        while (curIdx < vertexesSize - 1) {
            Edge edge = minHeapForEdge.extractMin();
//        если родитель(m.входящее) != родитель(m.исходящее) то
            if (getParent(edge.vertexOne) != getParent(edge.vertexTwo)) {
//        Объединить(m.входящее, m.исходящее)
                union(edge.vertexOne, edge.vertexTwo);
//        остов.добавить(m)
                rez[curIdx++] = edge;
            }
        }
        return rez;
    }

    /**
     * можно добавить подсчет вершин что бы было +- сбалансированное дерев не большой вложенности
     * с равномерным распределением
     * todo
     *
     * @param vertexOne
     * @param vertexTwo
     */
    private void union(int vertexOne, int vertexTwo) {
        int parentOne = getParent(vertexOne);
        int parentTwo = getParent(vertexTwo);
        if (vertexOne != vertexTwo) {
            vertexes[parentOne] = vertexTwo;
        }
    }

    private int getParent(int vertexOne) {
        int idx = vertexOne;

        while (idx != vertexes[idx]) {
            idx = vertexes[idx];
        }
        return idx;
    }

    private MinHeapForEdge fillMinHeap() {
        MinHeapForEdge minHeapForEdge = new MinHeapForEdge(vertexesSize);
        // добавляем мапу для того что бы не помещать в хип зеркальные мосты типа 1-2 2-1
        Map<Integer, List<Integer>> revertedPair = new HashMap<>();
        for (int i = 0; i < vertexesSize; i++) {
            for (int j = 0; j < adjacencyVector[i].length; j++) {
                if (adjacencyVector[i][j] != null) {
                    Edge edge = adjacencyVector[i][j];
                    edge.vertexOne = i;
                    minHeapForEdge.add(edge);
                }
            }
        }
        return minHeapForEdge;
    }
}
