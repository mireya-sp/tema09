package com.mireyaserrano.tema09.lib;

import java.util.Random;

public class MetodosArrays {
    public static void solicitarDatosArray(double[] array){
        if (array == null){
            return ;
        }
        for (int i = 0; i < array.length; i++){
            System.out.printf("a [%d]?\n", i);
            array[i] = Double.parseDouble(Escaner.lector.nextLine());
        }
    }

    public static String arrayToString(double[] array, int decimales){
        if (array == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        String formato = "%." + decimales + "f";
        for (int i = 0; i < array.length; i++){
            if (i == array.length-1){
                coma = "";
            }
            sb.append(espacio).append(String.format(formato, array[i])).append(coma);
            if (i == 0){
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void rellenarArray(double[] array, double valorMinimo, double valorMaximo){
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = aleatorio(valorMinimo, valorMaximo);
        }
    }

    public static void rellenarArray(int[] array, int valorMinimo, int valorMaximo){
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(valorMinimo, valorMaximo+1);
        }
    }

    public static double aleatorio(double valorMinimo, double valorMaximo){
        Random random = new Random();
        return valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
    }

    public static double mediaArray(double[] array){
        double suma = 0;
        for (double numero : array){
            suma += numero;
        }
        return suma / array.length;
    }

    public static double mediaArrayCondicion(double[] array, int num){
        double suma = 0;
        int contador = 0;
        for (double numero : array){
            if (numero >= num){
                suma += numero;
                contador += 1;
            }
        }
        return suma / contador;
    }


    public static void solicitarDatosArray(char[] array){
        if (array == null){
            return;
        }
        for (int i = 0; i < array.length; i++){
            System.out.printf("a [%d]?\n", i);
            array[i] = Escaner.lector.nextLine().charAt(0);
        }
    }


    public enum Paridad{
        PAR, IMPAR
    }

    public static String arrayToString(int[] array){
        if (array == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        String formato = "%d";
        for (int i = 0; i < array.length; i++){
            if (i == array.length-1){
                coma = "";
            }
            sb.append(espacio).append(String.format(formato, array[i])).append(coma);
            if (i == 0){
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String arrayToString(char[] array, Paridad paridad){
        final int NUM_ELEMENTOS = paridad == Paridad.PAR ? array.length / 2 : array.length / 2+1;
        char [] resultado = new char [NUM_ELEMENTOS];
        int contador = 0;
        for (int i = paridad == Paridad.PAR ? 0: 1; i < array.length; i += 2){
            resultado[contador++] = array[i];
        }
        return java.util.Arrays.toString(resultado);
    }

    public static int determinarLongitudMaxima(double[] array, int decimales){
        int longitudMaxima = 0;
        String formato = "%." + decimales + "f";
        for (double numero : array){
            int longitudActual = String.format(formato, numero).length();
            if (longitudMaxima < longitudActual){
                longitudMaxima = longitudActual;
            }
        }
        return longitudMaxima;
    }

    public static int determinarLongitudMaxima(int[] array){
        int longitudMaxima = 0;
        String formato = "%d";
        for (int numero : array){
            int longitudActual = String.format(formato, numero).length();
            if (longitudMaxima < longitudActual){
                longitudMaxima = longitudActual;
            }
        }
        return longitudMaxima;
    }

    public static String arrayToString(double[] array, int decimales, int columnas){
        return arrayToString(array, decimales, columnas, 2);
    }

    public static String arrayToString(double[] array, int decimales, int columnas, int padding) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int tamanyoColumna = determinarLongitudMaxima(array, decimales) + padding;
        String formato = "%" + tamanyoColumna + "." + decimales + "f";
        String formatoColumna = "%" + tamanyoColumna + "s";
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format(formatoColumna, String.format(formato, array[i])));
            if ((i + 1) % columnas == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
