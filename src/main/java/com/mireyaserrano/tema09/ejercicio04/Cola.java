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

    /**
     * Añade objetos a la cola
     * @param e El objeto que se añade a la cola
     * @return Si se ha añadido o no, con un boolean
     */
    @Override
    public boolean add(Object e) {
        return arrayList.add( (T)e );
    }

    /**
     * Elimina el primer elemento de la cola
     * @return El elemento que se ha eliminado
     */
    @Override
    public Object remove() {
        return arrayList.remove(0);
    }

    /**
     * Consigue el size de la cola
     * @return El size de la cola
     */
    @Override
    public int size() {
        return arrayList.size();
    }

    /**
     * Se busca el primer elemento de la cola
     * @return El primer elemento de la cola
     */
    @Override
    public Object peek() {
        return arrayList.get(0);
    }

    /**
     * Comprueba si la cola está vacía
     * @return Si la cola está vacía o no, con un boolean
     */
    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
