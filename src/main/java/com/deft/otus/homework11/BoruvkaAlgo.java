package com.deft.otus.homework11;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class BoruvkaAlgo implements SpanningTree {

    private final Edge[][] adjacencyVector;
    private final int vertexesSize;
    private final int[] parents;

    public BoruvkaAlgo(Edge[][] adjacencyVector) {
        this.adjacencyVector = adjacencyVector;
        vertexesSize = adjacencyVector.length;
        parents = new int[vertexesSize];
        for (int i = 0; i < vertexesSize; i++) {
            parents[i] = i;
        }
    }

    @Override
    public Edge[] getSpanningTree() {
        return boruvkaAlgo();
    }

    private Edge[] boruvkaAlgo() {
        List<Edge> spanningTree = new ArrayList<>();
//        для v из V
        for (int i = 0; i < adjacencyVector.length; i++) {
//        если родитель[v] != v0 то
                int parent = getParent(i);
                Edge[] v = adjacencyVector[parent];
                Edge m = getMinWeight(v, i);
                m.vertexOne = i;
//        остов.добавить(m)
                spanningTree.add(m);
//        Объединить(v, m.исходящее)
                union(m.vertexOne, m.vertexTwo);
        }

        return spanningTree.toArray(new Edge[0]);
    }

    private Edge getMinWeight(Edge[] v, int fromIdx) {
        int minVal = Integer.MAX_VALUE;
        int minIdxI = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != null) {
                if (v[i].weight < minVal && getParent(fromIdx) != getParent(v[i].vertexTwo)) {
                    minVal = v[i].weight;
                    minIdxI = i;
                }
            }
        }
        return v[minIdxI];
    }

    /**
     * with recursion
     * without recursion see {@see KraskalAlgo.class}
     *
     * @param i
     * @return
     */
    private int getParent(int i) {
        if (i == parents[i]) {
            return i;
        } else {
            return getParent(parents[i]);
        }
    }

    private void union(int vertexOne, int vertexTwo) {
        int parentOne = getParent(vertexOne);
        int parentTwo = getParent(vertexTwo);
        if (parentOne != parentTwo) {
            parents[parentOne] = parentTwo;
        }
    }
}
