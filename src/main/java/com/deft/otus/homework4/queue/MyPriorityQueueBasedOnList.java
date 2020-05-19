package com.deft.otus.homework4.queue;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 5/17/20
 */
public class MyPriorityQueueBasedOnList<T> implements IQueue<T> {

    private final List<MyQueue<T>> priorityList;

    public MyPriorityQueueBasedOnList(int maxPriorityLvl) {
        priorityList = new ArrayList<>();
        for (int i = 0; i < maxPriorityLvl; i++) {
            priorityList.add(i, new MyQueue<>());
        }
    }

    public void enqueue(int priority, T item) {
        priorityList.get(priority).enqueue(item);
    }

    public T dequeue() {
        for (MyQueue<T> tMyQueue : priorityList) {
            if (tMyQueue.hasNext()) {
                return tMyQueue.dequeue();
            }
        }
        return null;
    }
}
