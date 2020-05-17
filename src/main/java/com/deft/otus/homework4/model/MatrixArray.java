package com.deft.otus.homework4.model;

/*
 * Created by sgolitsyn on 5/15/20
 */
public class MatrixArray<T> implements IArray<T> {
    private SingleArray<IArray<T>> array;
    private int size;
    private final int capacity;

    public MatrixArray() {
        this(10);
    }

    public MatrixArray(int capacity) {
        this.capacity = capacity;
        array = new SingleArray<>(capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size >= array.size() * capacity) {
            resize();
        }
        array.get(size / capacity).add(item);
        size++;
    }

    private void resize() {
        array.add(new SingleArray<>(10));
    }

    @Override
    public T get(int index) {
        return array.get(index / capacity).get(index % capacity);
    }

    @Override
    public void add(T item, int index) {
        if (size >= array.size() * capacity) {
            resize();
        }
        int arrIdx = index / capacity;
        int elIdx = index % capacity;
        IArray<T> destArray = array.get(arrIdx);
        for (int i = arrIdx; i < size(); i++) {
            T lastEl = destArray.get(destArray.size() - 1);
            System.arraycopy(destArray, elIdx, destArray, elIdx + 1, capacity - elIdx - 1 - 1);
            add(lastEl, (arrIdx + 1) * capacity + 1);
        }


    }

    @Override
    public T remove(int index) {
        return null;
    }

}
