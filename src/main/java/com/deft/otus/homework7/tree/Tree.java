package com.deft.otus.homework7.tree;

/*
 * Created by sgolitsyn on 6/17/20
 */
public interface Tree<T extends Comparable<T>, V> {

    V find(T key);

    void insert(V obj);

    /**
     * should look on 3 base cases
     * 1) delete node is a leaf
     * 2) delete node have only one child
     * 3) delete node have 2 children
     *
     * @param key
     */
    void delete(T key);
}
