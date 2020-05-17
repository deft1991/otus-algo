package com.deft.otus.homework4.model;

/*
 * Created by sgolitsyn on 5/15/20
 */
public class SingleArray<T> implements IArray<T> {
    private Object[] array;
    int size;

    public SingleArray() {
        this(0);
    }

    public SingleArray(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        resize();
        array[size()] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void add(T item, int index) {
        resize();
        System.arraycopy(array, index, array, index + 1, size() - index);
        array[index] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        T item = (T) array[index];
        Object[] newArray = new Object[size() - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size() - 1 - index);
        size--;
        array = newArray;
        return item;
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}
