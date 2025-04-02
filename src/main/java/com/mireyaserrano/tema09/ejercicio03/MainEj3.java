package com.mireyaserrano.tema09.ejercicio03;

public class MainEj3 {
    public static void main(String[] args){
        Pila<Integer> pila = new Pila<>();
        pila.push(7);
        pila.pop();
        pila.push(12);
        System.out.println(pila + " " + pila.size() + " " + pila.top());
    }
}
