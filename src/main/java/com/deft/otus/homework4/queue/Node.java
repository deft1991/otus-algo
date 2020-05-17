package com.deft.otus.homework4.queue;

/*
 * Created by sgolitsyn on 5/17/20
 */
public class Node<T> {

    private T item;
    private Node<T> next;

    public Node(T item) {
        this.item = item;
    }

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
