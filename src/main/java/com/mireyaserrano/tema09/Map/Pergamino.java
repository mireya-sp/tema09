package com.mireyaserrano.tema09.Map;

import java.util.*;

public class Pergamino<K, V> implements Map<K, V>{
    private static final int DEFAULT_SIZE = 10;
    private final List<Pair>[] data;
    private int count;

    public Pergamino() {
        this(DEFAULT_SIZE);
    }

    public Pergamino(int capacity) {
        data = new List[capacity];
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get((K)key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Pair<K, V> pair = getPair((K)key);
        if (pair == null) {
            return null;
        }
        return pair.getValue();
    }

    @Override
    public V put(K key, V value) {
        int position = key.hashCode() % data.length;
        if (data[position] == null){
            data[position] = new ArrayList<>();
        }
        Pair<K, V> pair = getPair(key);
        if (pair == null){
            data[position].add(new Pair(key, value));
            return null;
        }
        V oldValue = pair.getValue();
        pair.setValue(value);
        return oldValue;
    }

    private Pair<K, V> getPair(K key) {
        int position = key.hashCode() % data.length;
        List<Pair> pairs = data[position];
        for (Pair pair : pairs){
            if (pair.getKey().equals(key)){
                return pair;
            }
        }
        return null;
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

    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public Collection<V> values() {
        return List.of();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }
}
