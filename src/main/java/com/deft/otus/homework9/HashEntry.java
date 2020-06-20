package com.deft.otus.homework9;

/*
 * Created by sgolitsyn on 6/20/20
 */

public class HashEntry<K, V> {

   private final K key;
   private V value;
   private HashEntry<K, V> next;


    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashEntry<K, V> getNext() {
        return next;
    }

    public void setNext(HashEntry<K, V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
