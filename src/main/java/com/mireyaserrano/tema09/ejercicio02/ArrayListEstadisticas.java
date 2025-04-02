package com.mireyaserrano.tema09.ejercicio02;

import java.util.ArrayList;

public class ArrayListEstadisticas implements IEstadisticas{
    private ArrayList<Double> array = new ArrayList<>();

    @Override
    public double minimo() {
        double min = array.get(0);
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) < min){
                min = array.get(i);
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = array.get(0);
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) > max){
                max = array.get(i);
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double suma = 0;
        for (int i = 0; i < array.size(); i++) {
            suma += array.get(i);
        }
        return suma;
    }

    @Override
    public double media() {
        double media = sumatorio() / array.size();
        return media;
    }

    @Override
    public double moda() {
        double moda = 0;
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                if (array.get(i) == array.get(j) && i != j){
                    moda = array.get(i);
                }
            }
        }
        return moda;
    }
}
