package com.mireyaserrano.tema09.ejercicio05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ejercicio05 {
    public static int[] majorMenor(ArrayList<Paciente> pacientes){
        int[] menorMayor = new int[2];
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getFechaNac().isBefore(pacientes.get(menorMayor[0]).getFechaNac())){
                menorMayor[1] = i;
            }
            if (pacientes.get(i).getFechaNac().isAfter(pacientes.get(menorMayor[0]).getFechaNac())){
                menorMayor[0] = i;
            }
        }
        return menorMayor;
    }

    public static int[] pacientsPerSexe(ArrayList<Paciente> pacientes){
        int[] porSexo = new int[2];
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getSexo() == Paciente.sexo.M){
                porSexo[0]++;
            }else{
                porSexo[1]++;
            }
        }
        return porSexo;
    }

    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        pacientes.add(new Paciente("1", LocalDate.parse("12/02/1980", dateTimeFormatter), Paciente.sexo.F, 1.63, 57));
        pacientes.add(new Paciente("2", LocalDate.parse("07/03/1990", dateTimeFormatter), Paciente.sexo.F, 1.74, 60.5));
        pacientes.add(new Paciente("3", LocalDate.parse("20/03/1967", dateTimeFormatter), Paciente.sexo.F, 1.62, 50.8));
        pacientes.add(new Paciente("4", LocalDate.parse("20/04/1972", dateTimeFormatter), Paciente.sexo.M, 1.78, 72.5));
        pacientes.add(new Paciente("5", LocalDate.parse("29/02/1960", dateTimeFormatter), Paciente.sexo.M, 1.8, 85.2));

        int[] edades = majorMenor(pacientes);
        int[] porSexo = pacientsPerSexe(pacientes);
        System.out.printf("PACIENTE MAYOR Edad: %d Sexo: %S\n", pacientes.get(edades[1]).getEdad(), pacientes.get(edades[1]).getSexo());
        System.out.printf("PACIENTE MENOR Edad: %d Sexo: %S\n\n", pacientes.get(edades[0]).getEdad(), pacientes.get(edades[0]).getSexo());
        System.out.println("Cantidad de pacientes por sexos:");
        System.out.printf("Hombres: %d      Mujeres: %d\n\n", porSexo[0], porSexo[1]);

        for (int i = 0; i < pacientes.size(); i++) {
            System.out.printf("Paciente numero %d: %s\n", (i+1), pacientes.get(i).segunIMC());
        }
    }


}
