package com.mireyaserrano.tema09.ejercicio10;

import java.time.LocalDate;
import java.time.Period;

public class Hijo {
    private final String nombre;
    private final LocalDate fechaNac;

    public Hijo(String nombre, LocalDate fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public int getEdad(){
        LocalDate now = LocalDate.now();
        Period periodo = Period.between(fechaNac, now);
        return periodo.getYears();
    }
}
