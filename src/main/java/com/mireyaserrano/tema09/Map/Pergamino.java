package com.mireyaserrano.tema09.Map;

import java.util.*;

public class Pergamino<K, V> implements Map<K, V>{
    private static final int DEFAULT_GROW_FACTOR = 2;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 10;
    private List<Pair>[] data;
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
    public V put(K key, V value){
        return put(key, value, data);
    }

    private V put(K key, V value, List<Pair>[] array) {
        int position = key.hashCode() % array.length;
        if (array[position] == null){
            array[position] = new ArrayList<>();
        }
        Pair<K, V> pair = getPair(key);
        if (pair == null){
            array[position].add(new Pair(key, value));
            count++;
            if ((double) count / array.length > DEFAULT_LOAD_FACTOR) {
                resize();
            }
            return null;
        }
        V oldValue = pair.getValue();
        pair.setValue(value);
        return oldValue;
    }

    private void resize(){
        List<Pair>[] aux = new List[data.length * DEFAULT_GROW_FACTOR];
        for (List<Pair> arrayList : data){
            if (arrayList != null){
                for (Pair<K, V> pair : arrayList) {
                    put(pair.getKey(), pair.getValue(), aux);
                }
            }
        }
        data = aux;
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (List<Pair> arrayList : data){
            if (arrayList != null){
                for (Pair<K, V> pair : arrayList) {
                    sb.append("Key: ").append(pair.getKey());
                    sb.append(", Value: ").append(pair.getValue()).append("\n");
                }
            }
        }
        return sb.toString();
    }
}
