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

    /**
     * Se recibe un objeto que se quiere añadir a la pila y lo añade
     * @param e El objeto a añadir a la pila
     * @return El objeto que se añade a la pila
     */
    @Override
    public Object push(Object e) {
        list.add( (T)e );
        return e;
    }

    /**
     * Saca el útimo obejto de la pila, que es como funcionan las pilas
     * @return El elemento que se ha eliminado
     */
    @Override
    public Object pop() {
        return list.remove(list.getLast());
    }

    /**
     * Da el size de la pila
     * @return El size de la pila
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Mira que objeto está en el final de la pila, encima de todos los elementos
     * @return El objeto que está encima de los demás
     */
    @Override
    public Object top() {
        return list.getLast();
    }

    /**
     * Comprueba si la pila está vacía
     * @return Si la pila está vacía o no, un boolean
     */
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
