package com.deft.otus.homework7.tree;

/*
 * Created by sgolitsyn on 6/17/20
 */
public abstract class BaseTree<T extends Comparable<T>, V extends Key<T>> implements Tree<T, V>, Detour, GetMaxAndMin {

    private Node<T, V> root;

    @Override
    public abstract V find(T key);

    @Override
    public abstract Node<T, V> insert(V obj);

    @Override
    public abstract void delete(T key);


    @Override
    public void preOrder() {
        preorder(root);
    }

    private void preorder(Node<T, V> node) {
        if (node != null) {
            preorder(node.getLeft());
            System.out.println(node.getValue());
            preorder(node.getRight());
        }
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T, V> node) {
        if (node != null) {
            System.out.println(node.getValue());
            inOrder(node.getLeft());
            inOrder(node.getRight());
        }
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T, V> node) {
        if (node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    @Override
    public Node<T, V> getMin(Node node) {
        Node<T, V> cur, prev = null;
        cur = node;

        while (cur != null) {
            prev = cur;
            cur = cur.getLeft();
        }
        return prev;
    }

    @Override
    public Node<T, V> getMax(Node node) {
        Node<T, V> cur, prev = null;
        cur = node;

        while (cur != null) {
            prev = cur;
            cur = cur.getRight();
        }
        return prev;
    }

    public Node<T, V> getRoot() {
        return root;
    }

    public void setRoot(Node<T, V> root) {
        this.root = root;
    }
}
