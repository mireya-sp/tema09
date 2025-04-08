package com.mireyaserrano.tema09.ejercicio11;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Alumno {
    private static int id = 0;
    private final int idAlumno;
    private final String nombre;
    private final Grupo grupo;
    private final ArrayList<Asignatura> asignaturas;

    public Alumno(String nombre, Grupo grupo) {
        idAlumno = id++;
        this.nombre = nombre;
        this.grupo = grupo;
        asignaturas = new ArrayList<>();
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return idAlumno == alumno.idAlumno;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAlumno);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", grupo=" + grupo +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
