package com.deft.otus.homework4.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 5/17/20
 */
public class MyArrayList<T> implements IArray<T> {

    private List<T> list;

    public MyArrayList() {
        this.list = new ArrayList<>();
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void add(T item, int index) {
        list.add(index, item);
    }

    @Override
    public T remove(int index) {
        return list.remove(index);
    }
}
