package com.mireyaserrano.tema09.ejercicio05;

import java.time.LocalDate;
import java.time.Period;

public class Paciente {
    public enum sexo{
        M, F
    }

    private static int num = 0;
    private int id;
    private final String nombre;
    private final LocalDate fechaNac;
    private final sexo sexo;
    private double altura;
    private double peso;

    public Paciente(String nombre, LocalDate fechaNac, sexo sexo, double altura, double peso) {
        id = num++;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public static int getNum() {
        return num;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public sexo getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public int getEdad(){
        LocalDate now = LocalDate.now();
        Period periodo = Period.between(fechaNac, now);
        return periodo.getYears();
    }

    public double getIMC(){
        return peso / (altura*altura);
    }

    private enum Mensaje{
        I("Peso insuficeinte"),
        N("Peso normal"),
        S1("Sobrepeso grado I"),
        S2("Sobrepeso grado II"),
        S3("Sobrepeso grado III");

        private final String texto;

        Mensaje(String texto){this.texto = texto;}

        @Override
        public String toString() {return texto;}
    }

    public Mensaje segunIMC(){
        double imc = getIMC();
        if (imc < 18.5 ){
            return Mensaje.I;
        } else if (imc >=18.5 && imc <= 24.9) {
            return Mensaje.N;
        } else if (imc >= 25 && imc <= 26.9) {
            return Mensaje.S1;
        } else if (imc >= 27 && imc <= 29.9) {
            return Mensaje.S2;
        } else {
            return Mensaje.S3;
        }
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", Edad=" + getEdad() +
                ", sexo=" + sexo +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
