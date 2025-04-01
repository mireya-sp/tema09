package com.mireyaserrano.tema09;

public class MainInterfaces {
    public static void main(String[] args){
        GenericDynamicArray<Integer> datos = new GenericDynamicArray<>(100);
        for (int i = 0; i < 50; i++) {
            datos.add(i);
        }

        datos.set(10, null);

        for (int numero : datos) {
            System.out.println(numero);
        }
        /*
        for (int numero : datos){
            System.out.println(numero);
        }
        for (int numero : datos){
            System.out.println(numero);
        }
        */

    }
}
