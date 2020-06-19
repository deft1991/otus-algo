package com.deft.otus.homework7.tree;

/*
 * Created by sgolitsyn on 6/17/20
 *
 * interface for different detours for Tree
 */
public interface Detour {

    /**
     * visit left
     * print
     * visit right
     */
    void preOrder();

    /**
     * print
     * visit left
     * visit right
     */
    void inOrder();

    /**
     * visit left
     * visit right
     * print
     */
    void postOrder();
}
