package com.mireyaserrano.tema09.ejercicio01;

import com.mireyaserrano.tema09.lib.MetodosArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio01 {
    public static ArrayList<Integer> primeroParesDespuesImpares(int[] array){
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

    public static void main(String[] args){
        int[] array = new int[10];
        MetodosArrays.rellenarArray(array, 0, 50);
        System.out.println(Arrays.toString(array));
        System.out.println("Ordenando array...");
        System.out.println(primeroParesDespuesImpares(array).toString());
    }
}
