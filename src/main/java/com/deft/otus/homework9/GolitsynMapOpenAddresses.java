package com.deft.otus.homework9;

/*
 * Created by sgolitsyn on 6/25/20
 */
public class GolitsynMapOpenAddresses<K, V> extends GolitsynsMap<K, V> {

    @Override
    public V put(K key, V value) {
        if (getSize() + 1 >= super.getCapacity() * 0.75) {
            rehash();
        }
        int idx = getBucketIdx(key);
        HashEntry<K, V> entry = new HashEntry<>(key, value);
        while (true) {
            HashEntry<K, V> oldEntry = getBuckets()[idx];
            if (oldEntry != null) {
                // if keys equals swap values
                if (oldEntry.getKey().equals(key)) {
                    getBuckets()[idx] = entry;
                    return oldEntry.getValue();
                } else if (oldEntry.isRemoved()) {
                    getBuckets()[idx] = entry;
                    return null;
                } else {

                    idx = (idx + 1) % getCapacity();
                    // todo can add other variant
                }
            } else {
                getBuckets()[idx] = entry;
                return null;
            }
        }
    }

    @Override
    public V get(Object key) {
        int idx = getBucketIdx(key);
        int remIdx = -1;
        while (true) {
            HashEntry<K, V> entry = getBuckets()[idx];
            if (entry == null) {
                return null;
            } else {
                if (entry.isRemoved() && remIdx == -1) {
                    remIdx = idx;
                } else if (!entry.isRemoved() && entry.getKey().equals(key)) {
                    if (remIdx != -1) {
                        swap(idx, remIdx);
                    }
                    return entry.getValue();
                } else {
                    idx++;
                }
            }

        }
    }

    private void swap(int idx, int remIdx) {
        HashEntry<K, V> entry = getBuckets()[idx];
        getBuckets()[idx] = getBuckets()[remIdx];
        getBuckets()[remIdx] = entry;
    }

    /**
     * recreate array
     * //todo realize this method in future
     */
    private void rehash() {

    }

    @Override
    public V remove(Object key) {
        int idx = getBucketIdx(key);

        while (true) {
            HashEntry<K, V> entry = getBuckets()[idx];
            if (entry == null) {
                return null;
            }
            if (entry.getKey().equals(key)) {
                entry.setRemoved(true);
                return entry.getValue();
            } else {
                idx++;
            }
        }
    }

    protected int getBucketIdx(Object key) {
        return key.hashCode() % super.getCapacity();
    }
}
