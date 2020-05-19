package com.deft.otus.homework4.queue;

/*
 * Created by sgolitsyn on 5/17/20
 */
public interface IQueue<T> {

    // enqueue(int priority, T item) - поместить элемент в очередь
    public void enqueue(int priority, T item);

    //T dequeue() - выбрать элемент из очереди
    public T dequeue();
}
