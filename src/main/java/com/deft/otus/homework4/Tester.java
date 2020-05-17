package com.deft.otus.homework4;

import com.deft.otus.homework4.model.IArray;
import com.deft.otus.homework4.queue.MyPriorityQueueBasedOnList;
import com.deft.otus.homework4.queue.MyPriorityQueueImpl;
import com.deft.otus.homework4.queue.MyQueue;

/*
 * Created by sgolitsyn on 5/15/20
 */
public class Tester {
//    public static void main(String[] args) {
//        IArray<String> singleArray = new SingleArray<>();
//        IArray<String> vectorArray = new VectorArray<>();
//        IArray<String> factorArray = new FactorArray<>();
//        IArray<String> matrixArray = new MatrixArray<>();
//        IArray<String> myArrayList = new MyArrayList<>();
//        testAddIndex(singleArray, 10);
//        testAddIndex(vectorArray, 10);
//        testAddIndex(factorArray, 10);
//        testAddIndex(matrixArray, 10);
//        testAddIndex(myArrayList, 10);
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//        testAddIndex(singleArray, 100);
//        testAddIndex(vectorArray, 100);
//        testAddIndex(factorArray, 100);
//        testAddIndex(matrixArray, 100);
//        testAddIndex(myArrayList, 100);
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//        testAddIndex(singleArray, 1000);
//        testAddIndex(vectorArray, 1000);
//        testAddIndex(factorArray, 1000);
//        testAddIndex(matrixArray, 1000);
//        testAddIndex(myArrayList, 1000);
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//        testAddIndex(singleArray, 10000);
//        testAddIndex(vectorArray, 10000);
//        testAddIndex(factorArray, 10000);
//        testAddIndex(matrixArray, 10000);
//        testAddIndex(myArrayList, 10000);
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//        testAddIndex(singleArray, 100000);
//        testAddIndex(vectorArray, 100000);
//        testAddIndex(factorArray, 100000);
//        testAddIndex(matrixArray, 100000);
//        testAddIndex(myArrayList, 100000);
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
////        testAddIndex(singleArray, 1000000);
////        testAddIndex(vectorArray, 1000000);
//        testAddIndex(factorArray, 1000000);
//        testAddIndex(matrixArray, 1000000);
//        testAddIndex(myArrayList, 1000000);
//    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        for (int i = 0; i < 100; i++) {
            myQueue.enqueue(String.valueOf(i));
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=");
        MyPriorityQueueBasedOnList<String> priorityQueueBasedOnList = new MyPriorityQueueBasedOnList<>(10);
        MyPriorityQueueImpl<Integer> myPriorityQueue = new MyPriorityQueueImpl<>(100, (o1, o2) -> {
            int first = ((int) o1) / 10;
            int second = ((int) o2) / 10;
            return Integer.compare(second, first);
        });
        for (int i = 0; i < 100; i++) {
            priorityQueueBasedOnList.enqueue(i % 10, String.valueOf(i));
            myPriorityQueue.enqueue(i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(priorityQueueBasedOnList.dequeue());
            System.out.println(myPriorityQueue.dequeue());
        }
    }

    private static void testAddArray(IArray<String> iArray, long count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            iArray.add("String add");
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    private static void testAddIndex(IArray<String> iArray, long count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            iArray.add(String.valueOf(i), i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    private static void testRemoveIndex(IArray<String> iArray, long count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            String remove = iArray.remove(0);
            System.out.println(remove);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
}
