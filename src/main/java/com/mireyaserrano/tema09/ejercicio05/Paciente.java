package com.mireyaserrano.tema09.ejercicio05;

import java.time.LocalDate;

public class Paciente {
    private enum sexo{
        M, F
    }

    private int id;
    private final String nombre;
    private final LocalDate fechaNac;
    private final sexo sexo;
    private double altura;
    private double peso;

    public Paciente(int id, String nombre, LocalDate fechaNac, sexo sexo, double altura, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }
}
