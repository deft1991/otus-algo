package com.deft.otus.homework4.model;

/*
 * Created by sgolitsyn on 5/15/20
 */
public class FactorArray<T> implements IArray<T> {
    private Object[] array;
    private int size;
    private final double raiseCoef;

    public FactorArray() {
        this(1.75);
    }

    public FactorArray(double raiseCoef) {
        if (raiseCoef < 1){
            throw new RuntimeException("raiseCoefficient should be greater than 1");
        }
        this.raiseCoef = raiseCoef;
        array = new Object[0];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size >= array.length) {
            resize();
        }
        array[size] = item;
        size++;
    }

    private void resize() {
        Object[] newArr = new Object[(int) (size() * raiseCoef + 1)];
        System.arraycopy(array, 0, newArr, 0 , size());
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
        Object[] newArr = new Object[size() - 1];
        System.arraycopy(array, 0, newArr, 0, index);
        System.arraycopy(array, index + 1, newArr, index, size - index - 1);
        array = newArr;
        size--;
        return item;
    }
}