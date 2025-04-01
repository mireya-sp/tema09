package com.mireyaserrano.tema09;

public class MainInterfaces {
    public static void main(String[] args){
        DynamicArray<Integer> datos = new DynamicArray<>(100);
        for (int i = 0; i < 50; i++) {
            datos.add(i);
        }

        for (int numero : datos){
            System.out.println(numero);
        }
        for (int numero : datos){
            System.out.println(numero);
        }
    }
}
