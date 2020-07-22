package com.deft.otus.homework9;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/*
 * Created by sgolitsyn on 6/20/20
 */
public class GolitsynsMap<K, V> implements Map<K, V> {

    HashEntry<K, V>[] buckets;
    private int size;

    // base capacity of map`s buckets
    private int capacity;

    // when should rehash map. calclates like 2 pow capacity
    private int treshHold;


    public GolitsynsMap() {
        capacity = 16;
        //noinspection unchecked
        buckets = (HashEntry<K, V>[]) new HashEntry[capacity];
        treshHold = 2 * (size + 1) * capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {

        int idx = getBucketIdx(key);

        HashEntry<K, V> entry = buckets[idx];

        while (entry != null){

            if (entry.getKey().equals(key)){
                return entry.getValue();
            } else {
                entry = entry.getNext();
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {

        HashEntry<K, V> entry = new HashEntry<>(key, value);

        int idx = getBucketIdx(key);

        HashEntry<K, V> oldEntry = buckets[idx];

        if (oldEntry != null) {

            while (oldEntry != null) {

                /*
                 * update value if keys equals
                 */
                if (oldEntry.getKey().equals(key)) {
                    V oldVal = oldEntry.getValue();
                    oldEntry.setValue(value);
                    return oldVal;
                } else {
                    oldEntry = oldEntry.getNext();
                }
            }
            entry.setNext(buckets[idx]);
            buckets[idx] = entry;
        } else {
            buckets[idx] = entry;
        }

        if (++size == treshHold) {
            reHash();
        }

        return null;
    }

    // todo not sure that I need it now
    private void reHash() {

    }

    private int getBucketIdx(Object key) {
        return key.hashCode() % capacity;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        //noinspection unchecked
        buckets = (HashEntry<K, V>[]) new HashEntry[capacity];
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public HashEntry<K, V>[] getBuckets() {
        return buckets;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
