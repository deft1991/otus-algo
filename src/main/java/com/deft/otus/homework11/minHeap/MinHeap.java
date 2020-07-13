package com.deft.otus.homework11.minHeap;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 7/13/20
 */
public class MinHeap {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(7);

        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);
        minHeap.print();
        System.out.println("-=-=-=-=-=-=-=-=-=");
        System.out.println(minHeap.getMin());
        minHeap.extractMin();
        System.out.println("-=-=-=-=-=-=-=-=-=");
        System.out.println(minHeap.getMin());
        minHeap.extractMin();
        System.out.println("-=-=-=-=-=-=-=-=-=");
        System.out.println(minHeap.getMin());
        minHeap.extractMin();
        System.out.println("-=-=-=-=-=-=-=-=-=");
        System.out.println(minHeap.getMin());
        minHeap.extractMin();
        System.out.println("-=-=-=-=-=-=-=-=-=");
        System.out.println(minHeap.getMin());
        minHeap.extractMin();
        System.out.println("-=-=-=-=-=-=-=-=-=");
        minHeap.print();
    }

    int[] heap;
    int length;
    int size;

    public MinHeap(int length) {
        this.length = length;
        this.heap = new int[length];
    }


    public void add(int value) {
        int currentPos = size;

        if (size >= length) {
            throw new RuntimeException("Full heap");
        }
        heap[size++] = value;
        int parent = getParentIdx(currentPos);

        while (heap[currentPos] < heap[parent]) {
            swap(parent, currentPos);
            currentPos = parent;
            parent = getParentIdx(currentPos);
        }
    }

    private int getParentIdx(int currentPos) {
        return (currentPos - 1) / 2;
    }

    public int getMin() {
        return heap[0];
    }

    public int extractMin() {
        int min = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return min;
    }

    private void heapify(int i) {
        if (!isLeaf(i)) {
            if (heap[0] > heap[getLeftChild(i)] || heap[0] > heap[getRightChild(i)]) {
                if (heap[getLeftChild(i)] < heap[getRightChild(i)]) {
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
        return 2 * i + 1 <= size;
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private boolean hasRightChild(int i) {
        return 2 * i + 2 <= size;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    public void print(){
        Arrays.stream(heap).limit(size).forEach(System.out::println);
    }
}
