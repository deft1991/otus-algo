package com.deft.otus.homework4.queue;

/*
 * Created by sgolitsyn on 5/17/20
 */
public class MyQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    public void enqueue(T item) {
        if (head == null) {
            head = tail = new Node<>(item);
        } else {
            Node<T> next = new Node<>(item);
            tail.setNext(next);
            tail = next;
        }
    }

    public T dequeue() {
        T item = head.getItem();
        head = head.getNext();
        return item;
    }

    public boolean hasNext() {
        return head != null;
    }
}
