package com.mireyaserrano.tema09.ejercicio01;

import java.util.ArrayList;

public class Ejercicio01 {
    public ArrayList<Integer> metodo(int[] array){
        ArrayList<Integer> paresImpares = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                paresImpares.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 != 0){
                paresImpares.add(array[i]);
            }
        }
        return paresImpares;
    }
}
