package com.mireyaserrano.tema09.interfaces;

import java.util.HashSet;
import java.util.Set;

public class MainInterfaces {
    public static void main(String[] args){
        Set<Integer> numeros = new HashSet<>();
        System.out.println(numeros.add(1));
        System.out.println(numeros.add(2));
        System.out.println(numeros.add(3));
        System.out.println(numeros.add(3));


        /*
        GenericDynamicArray<Integer> datos = new GenericDynamicArray<>(100);
        for (int i = 0; i < 50; i++) {
            datos.add(i);
        }

        datos.set(10, null);

        for (int numero : datos) {
            System.out.println(numero);
        }

        for (int numero : datos){
            System.out.println(numero);
        }
        for (int numero : datos){
            System.out.println(numero);
        }
        */

    }
}
