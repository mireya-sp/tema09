package com.mireyaserrano.tema09.ejercicio03;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> implements IPila{
    private List<T> list;

    public Pila() {
        list = new ArrayList<>();
    }

    public Pila(int capacity){
        list = new ArrayList<>(capacity);
    }

    @Override
    public Object push(Object e) {
        list.add( (T)e );
        return e;
    }

    @Override
    public Object pop() {
        return list.remove(list.getLast());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object top() {
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Pila{" +
                "List =" + list +
                '}';
    }
}
