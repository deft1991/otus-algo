package com.deft.otus.homework7.AVLTree;

import com.deft.otus.homework7.tree.BinarySearchTree;
import com.deft.otus.homework7.tree.Key;
import com.deft.otus.homework7.tree.Node;

/*
 * Created by sgolitsyn on 6/23/20
 */
public class AVLTree<T extends Comparable<T>, V extends Key<T>> extends BinarySearchTree<T, V> {

    private int getHeight(Node<T, V> node) {
        return node == null ? 0 : node.getHeight();
    }

    /**
     * balance factor
     *
     * @param Node node
     * @return getBalanceFactor
     */
    private int getBalanceFactor(Node<T, V> Node) {
//        return getHeight(Node.getLeft()) - getHeight(Node.getRight());
        return getHeight(Node.getRight()) - getHeight(Node.getLeft());
    }


    private void fixheight(Node<T, V> Node) {
        int leftH = getHeight(Node.getLeft());
        int rightH = getHeight(Node.getRight());
        Node.setHeight(Math.max(leftH, rightH) + 1);
    }

    /**
     * p             q
     * /\            /\
     * q  a   --->  b  p
     * /\               /\
     * b c              c a
     * perform rotation left around specific node
     */
    private Node<T, V> rotateRight(Node<T, V> p) {
        Node<T, V> q = p.getLeft();
        p.setLeft(q.getRight());
        q.setRight(p);
        fixheight(p);
        fixheight(q);
        return q;
    }

    /**
     * q             p
     * /\            /\
     * p c   <---   a  q
     * /\              /\
     * a b             b c
     * perform rotation around specific node
     */
    private Node<T, V> rotateLeft(Node<T, V> q) {
        Node<T, V> p = q.getRight();
        q.setRight(p.getLeft());
        p.setLeft(q);
        fixheight(q);
        fixheight(p);
        return p;
    }

    /**
     * function used to balance node
     */
    private Node<T, V> balance(Node<T, V> node) {
        fixheight(node);
        if (getBalanceFactor(node) == 2) {

            if (getBalanceFactor(node.getRight()) < 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        if (getBalanceFactor(node) == -2) {
            if (getBalanceFactor(node.getLeft()) > 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateLeft(node);
        }

        return node;
    }


    @Override
    public Node<T, V> insert(V obj) {
        if (getRoot() == null) {
            Node<T, V> root = new Node<>(obj.getKey(), obj);
            setRoot(root);
            root.setHeight(1 + getHeight(root.getLeft()) + getHeight(root.getRight()));
        }
        return putNode(getRoot(), obj.getKey(), obj);
    }

    Node<T, V> putNode(Node<T, V> node, T key, V value) {
        if (node == null) return new Node(key, value);
        if (node.getKey().compareTo(key) > 0) {
            node.setLeft(putNode(node.getLeft(), key, value));
        } else if (node.getKey().compareTo(key) < 0) {
            node.setRight(putNode(node.getRight(), key, value));
        } else if (node.getKey().compareTo(key) == 0) {
            node.setValue(value);
        }
        node.setHeight(1 + getHeight(node.getLeft()) + getHeight(node.getRight()));
        return balance(node);
    }
}
