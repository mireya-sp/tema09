package com.mireyaserrano.tema09.ejercicio11;

import java.util.Objects;

public class Aula {
    private final int codigo;
    private final double metrosCuadrados;

    public Aula(int codigo, double metrosCuadrados) {
        this.codigo = codigo;
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return codigo == aula.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Aula{" +
                "codigo=" + codigo +
                ", metrosCuadrados=" + metrosCuadrados +
                '}';
    }
}
