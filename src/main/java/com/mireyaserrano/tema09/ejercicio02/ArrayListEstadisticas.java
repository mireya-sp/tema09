package com.mireyaserrano.tema09.ejercicio02;

import java.util.ArrayList;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas {

    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for (double valor : this) {
            if (valor < min){
                min = valor;
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = Double.MIN_VALUE;
        for (double valor : this) {
            if (valor > max){
                max = valor;
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double suma = 0;
        for (int i = 0; i < size(); i++) {
            suma += get(i);
        }
        return suma;
    }

    @Override
    public double media() {
        return sumatorio() / size();
    }

    @Override
    public double moda() {
        double moda = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (get(i).equals(get(j)) && i != j){
                    moda = get(i);
                }
            }
        }
        return moda;
    }
}
