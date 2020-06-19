package com.deft.otus.homework7.tree;

/*
 * Created by sgolitsyn on 6/17/20
 */
public class Node<T extends Comparable<T>, V> implements Key<T> {

    private T key;
    private V value;
    private Node<T, V> left;
    private Node<T, V> right;

    public Node() {
    }

    public Node(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<T, V> getLeft() {
        return left;
    }

    public void setLeft(Node<T, V> left) {
        this.left = left;
    }

    public Node<T, V> getRight() {
        return right;
    }

    public void setRight(Node<T, V> right) {
        this.right = right;
    }
}
