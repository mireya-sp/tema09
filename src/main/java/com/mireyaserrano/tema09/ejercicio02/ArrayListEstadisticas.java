package com.mireyaserrano.tema09.ejercicio02;

import java.util.ArrayList;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas {

    /**
     * Recorre el arrayList para encontrar el double mínimo
     * @return El double mínimo
     */
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

    /**
     * Recorre el ArrayList para encontrar el double máximo
     * @return El double máximo
     */
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

    /**
     * Recorre el arrayList sumando todos los números
     * @return La suma total de todos los números del arrayList
     */
    @Override
    public double sumatorio() {
        double suma = 0;
        for (int i = 0; i < size(); i++) {
            suma += get(i);
        }
        return suma;
    }

    /**
     * Llama al metodo sumatorio y lo divide entre el size del arrayList para obtener la media
     * @return La media de todos los números del arrayList
     */
    @Override
    public double media() {
        return sumatorio() / size();
    }

    /**
     * Recorre el arrayList para encontrar números repetidos y calcular la moda
     * @return la moda
     */
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
