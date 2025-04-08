package com.mireyaserrano.tema09.ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

public class Empleado {
    private final String DNI;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNac;
    private int sueldo;
    private ArrayList<Hijo> hijos;

    public Empleado(String DNI, String nombre, String apellidos, LocalDate fechaNac, int sueldo, ArrayList<Hijo> hijos) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.hijos = hijos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public ArrayList<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Hijo> hijos) {
        this.hijos = hijos;
    }

    public Hijo removeHijo(String nombreHijo){
        int posicion = -1;
        for (int i = 0; i < hijos.size(); i++) {
            if (hijos.get(i).getNombre().equals(nombreHijo)){
                posicion = i;
            }
        }
        if (posicion == -1){
            return null;
        }
        return hijos.remove(posicion);
    }

    public int getEdad(){
        LocalDate now = LocalDate.now();
        Period periodo = Period.between(fechaNac, now);
        return periodo.getYears();
    }
}
