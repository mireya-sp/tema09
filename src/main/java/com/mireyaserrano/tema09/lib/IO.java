package com.mireyaserrano.tema09.lib;

import java.util.Scanner;

public class IO {
    /**
     * Solicita un texto y valida que su longitud este comprendida entre longitudMinima y longitudMaxima
     * @param mensaje Mensaje que se le mostrará al usuario
     * @param longitudMinima Número mínimo de caracteres que debe tener el texto
     * @param longitudMaxima Número máximo de caracteres que debe tener el texto
     * @return El texto leido validado
     */
    public static String solicitarString(String mensaje, int longitudMinima, int longitudMaxima){
        Scanner scanner = new Scanner(System.in);
        String texto;
        boolean valido;
        do {
            System.out.println(mensaje);
            texto = scanner.nextLine();
            valido = texto.length() >= longitudMinima && texto.length() <= longitudMaxima;
            if (!valido){
                System.err.printf("La longitud debe estar comprendida entre [%d - %d]\n", longitudMinima, longitudMaxima);
            }
        }while (!valido);
        scanner.close();
        return texto;
    }

    public static int solicitarInt(String mensaje, int min, int max) {
        int respuesta;
        do {
            //Solicitamos el 'int'
            System.out.println(mensaje);
            respuesta = Integer.parseInt(Escaner.lector.nextLine());
            //Validamos la respuesta
            if (respuesta<min||respuesta>max) {
                System.err.printf("El número introducido no puede ser inferior a %d, ni superior a %d.\n\n", min, max);
            }
        } while (respuesta<min||respuesta>max);
        return respuesta;
    }
}
