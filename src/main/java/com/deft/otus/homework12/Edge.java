package com.deft.otus.homework12;

/*
 * Created by sgolitsyn on 7/16/20
 */
public class Edge {
    int From;
    int To;
    int weight;

    public Edge() {
    }

    public Edge(int to, int weight) {
        To = to;
        this.weight = weight;
    }
}
