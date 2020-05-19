package com.deft.otus.homework4.queue;

import java.util.Comparator;

/*
 * Created by sgolitsyn on 5/17/20
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class MyPriorityQueueImpl<T> {

    private Comparable[] pQueue;
    private T[] queue;
    private int index;
    private Comparator<T> comparator;

    public MyPriorityQueueImpl(int capacity) {
        pQueue = new Comparable[capacity];
    }

    public MyPriorityQueueImpl(int capacity, Comparator<T> comparator) {
        queue = (T[]) new Object[capacity];
        this.comparator = comparator;
    }

    @SuppressWarnings("rawtypes")
    public void enqueue(Object item) {
        if (queue != null) {
            if (index == queue.length) {
                System.out.println("The priority queue is full!! can not insert.");
                return;
            }
            queue[index] = (T) item;
            index++;
        } else {
            if (index == pQueue.length) {
                System.out.println("The priority queue is full!! can not insert.");
                return;
            }
            pQueue[index] = (Comparable) item;
            index++;
        }
//        System.out.println("Adding element: " + item);
    }

    @SuppressWarnings("unchecked")
    public Object dequeue() {
        Object[] q;
        if (queue != null) {
            q = queue;
        } else {
            q = pQueue;
        }
        if (index == 0) {
            System.out.println("The priority queue is empty!! can not remove.");
            return null;
        }
        int maxIndex = 0;
        // find the index of the item with the highest priority
        for (int i = 1; i < index; i++) {
            if (comparator != null) {
                if (comparator.compare(queue[i], queue[maxIndex]) > 0) {
                    maxIndex = i;
                }
            } else {
                if (pQueue[i].compareTo(pQueue[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }
        }
        Object result = q[maxIndex];
//        System.out.println("removing: " + result);
        // move the last item into the empty slot
        index--;
        q[maxIndex] = q[index];
        return result;
    }

}
