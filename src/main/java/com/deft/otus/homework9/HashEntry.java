package com.deft.otus.homework9;

/*
 * Created by sgolitsyn on 6/20/20
 */

public class HashEntry<K, V> {

   private final K key;
   private V value;
   private HashEntry<K, V> next;
   private boolean isRemoved;


    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.isRemoved = false;
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

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }
}
