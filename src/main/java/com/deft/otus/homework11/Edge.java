package com.deft.otus.homework11;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class Edge {
    public int vertexOne;
    public int vertexTwo;
    public int weight;
//
//    public Edge(int vertexOne, int vertexTwo) {
//        this.vertexOne = vertexOne;
//        this.vertexTwo = vertexTwo;
//    }

    public Edge(int vertexOne, int vertexTwo, int weight) {
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.weight = weight;
    }

    public Edge(int vertexTwo, int weight) {
        this.vertexTwo = vertexTwo;
        this.weight = weight;
    }
}
