package com.deft.otus.homework4.model;

/*
 * Created by sgolitsyn on 5/15/20
 */
public class VectorArray<T> implements IArray<T> {
    private Object[] array;
    private final int raiseCoef;
    private int size;

    public VectorArray(int raiseCount) {
        if (raiseCount < 1) {
            throw new RuntimeException("raiseCount should be greater than 1");
        }
        array = new Object[0];
        this.raiseCoef = raiseCount;
    }

    public VectorArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() >= array.length) {
            resize();
        }
        array[size] = item;
        size++;
    }

    private void resize() {
        Object[] newArr = new Object[size() + raiseCoef];
        System.arraycopy(array, 0, newArr, 0, size());
        array = newArr;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void add(T item, int index) {
        if (size >= array.length) {
            resize();
        }
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
        System.arraycopy(array, index + 1, newArray, index, size() - index - 1);
        size--;
        array = newArray;
        return item;
    }
}
