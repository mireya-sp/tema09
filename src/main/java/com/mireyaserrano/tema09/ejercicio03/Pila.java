package com.mireyaserrano.tema09.ejercicio03;

import java.util.ArrayList;

public class Pila<T> implements IPila{
    private ArrayList<T> arrayList;

    public Pila() {
        arrayList = new ArrayList<>();
    }

    @Override
    public Object push(Object e) {
        arrayList.add( (T)e );
        return e;
    }

    @Override
    public Object pop() {
        return arrayList.remove(arrayList.getLast());
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public Object top() {
        return arrayList.getLast();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public String toString() {
        return "Pila{" +
                "arrayList=" + arrayList +
                '}';
    }
}
