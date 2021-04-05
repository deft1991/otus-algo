package com.deft.otus.homework11.minHeap;

import com.deft.otus.homework11.Edge;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class MinHeapForEdge {

    // use list because in more comfortable instead of resized array.
    // I do not want realize it here =(
    List<Edge> heap;
    int length;
    int size;

    public MinHeapForEdge(int length) {
        this.length = length;
        this.heap = new ArrayList<>(length);
    }


    public void add(Edge edge) {
        int currentPos = size;
        heap.add(edge);
        size++;
        int parent = getParentIdx(currentPos);

        while (heap.get(currentPos).weight < heap.get(parent).weight) {
            swap(parent, currentPos);
            currentPos = parent;
            parent = getParentIdx(currentPos);
        }
    }

    private int getParentIdx(int currentPos) {
        return (currentPos - 1) / 2;
    }

    public Edge getMin() {
        return heap.get(0);
    }

    public Edge extractMin() {
        Edge min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        size--;
        return min;
    }

    private void heapify(int i) {
        if (!isLeaf(i)) {
            if (heap.get(i).weight > heap.get(getLeftChild(i)).weight || heap.get(i).weight > heap.get(getRightChild(i)).weight) {
                if (heap.get(getLeftChild(i)).weight < heap.get(getRightChild(i)).weight) {
                    swap(i, getLeftChild(i));
                    heapify(getLeftChild(i));
                } else {
                    swap(i, getRightChild(i));
                    heapify(getRightChild(i));
                }
            }
        }
    }

    private boolean isLeaf(int i) {
        return !(hasLeftChild(i) || hasRightChild(i));
    }

    private boolean hasLeftChild(int i) {
        return 2 * i + 1 < heap.size() - 1;
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private boolean hasRightChild(int i) {
        return 2 * i + 2 < heap.size() - 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos) {
        Edge tmp;
        tmp = heap.get(fpos);
        heap.set(fpos, heap.get(spos));
        heap.set(spos, tmp);
    }

    public void print() {
        heap.stream().limit(heap.size()).forEach(System.out::println);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
