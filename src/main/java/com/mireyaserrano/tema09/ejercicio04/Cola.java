package com.mireyaserrano.tema09.ejercicio04;

import java.util.ArrayList;

public class Cola<T> implements ICola{
    private ArrayList<T> arrayList;

    public Cola(){
        arrayList = new ArrayList<>();
    }

    public Cola(int capacity){
        arrayList = new ArrayList<>(capacity);
    }

    @Override
    public boolean add(Object e) {
        return arrayList.add( (T)e );
    }

    @Override
    public Object remove() {
        return arrayList.remove(0);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public Object peek() {
        return arrayList.get(0);
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
