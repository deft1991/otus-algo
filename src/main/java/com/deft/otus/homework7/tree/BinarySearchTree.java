package com.deft.otus.homework7.tree;

/*
 * Created by sgolitsyn on 6/17/20
 */
public class BinarySearchTree<T extends Comparable<T>, V extends Key<T>> extends BaseTree<T, V> {

    public BinarySearchTree() {
        super();
    }

    @Override
    public V find(T key) {
        Node<T, V> current = getRoot();

        while (current.getKey().compareTo(key) != 0) {

            if (key.compareTo(current.getKey()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current == null) {
                return null;
            }
        }
        return current.getValue();
    }

    @Override
    public void insert(V obj) {
        Node<T, V> node = new Node<>(obj.getKey(), obj);

        if (getRoot() == null) {
            setRoot(node);
        } else {
            Node<T, V> current = getRoot();
            Node<T, V> parent;

            while (true) {
                parent = current;
                if (node.getKey().compareTo(current.getKey()) < 0) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(node);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(node);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void delete(T key) {
        Node<T, V> current = getRoot();
        Node<T, V> parent = getRoot();
        boolean isLeft = false;

        while (current.getKey().compareTo(key) != 0) {
            parent = current;
            if (key.compareTo(current.getKey()) < 0) {
                current = current.getLeft();
                isLeft = true;
            } else {
                current = current.getRight();
                isLeft = false;
            }
            if (current == null) {
                throw new RuntimeException("Element not found for delete");
            }
        }

        /*
         * first case when we have no children
         */
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == super.getRoot()) {
                super.setRoot(null);
            } else if (isLeft) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            /*
             * second case when we have only one child
             */
        } else if (current.getLeft() == null) {
            if (current == super.getRoot()) {
                super.setRoot(current.getRight());
            } else if (isLeft) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else if (current.getRight() == null) {
            if (current == super.getRoot()) {
                super.setRoot(current.getLeft());
            } else if (isLeft) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
            /*
             * third case when we have two children
             * 1) add to parent left sub tree.
             * 2) in delNode left sub tree find Max
             * 3) add to Max right subTree from delNode
             */
        } else {
            if (isLeft) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setLeft(current.getRight());
            }
            Node<T, V> max = getMax(current.getLeft());
            max.setRight(current.getRight());
            System.out.println("Deleted");
        }
    }
}
