package com.mireyaserrano.tema09.ejercicio08;

import java.util.Scanner;

public class Ejercicio08 {
    private static Scanner scanner = new Scanner(System.in);

    private static Diccionario diccionario = new Diccionario();

    /**
     * Menú principal del programa
     */
    public static void menu() {
        System.out.println("***********************\n" +
                "* GESTIÓN DICCIONARIO *\n" +
                "***********************\n" +
                "1. Añadir palabra\n" +
                "2. Modificar palabra\n" +
                "3. Eliminar palabra\n" +
                "4. Consultar palabra\n" +
                "5. Mostrar diccionario\n" +
                "---------------------\n" +
                "0. Salir");
    }

    public static void main(String[] args) {
        int opcion = 0;
        do {
            menu();
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0 -> System.out.println("Saliendo...");
                case 1 -> anyadirPalabra();
                case 2 -> modificarPalabra();
                case 3 -> eliminarPalabra();
                case 4 -> consultarPalabra();
                case 5 -> diccionario.getDiccionario();
                default -> System.out.println("Por favor introduce una opcioón válida");
            }

        } while (opcion != 0);
    }

    /**
     * Añadir palabra y definicion de la palabra en el diccionario
     */
    private static void anyadirPalabra() {
        System.out.println("Introduce la palabra a añadir");
        String palabra = scanner.nextLine();
        System.out.println("Itroduce la definición de " + palabra);
        String definicion = scanner.nextLine();
        diccionario.add(palabra, definicion);
    }

    /**
     * Modificar la definición de una palabra
     */
    private static void modificarPalabra() {
        System.out.println("Introduce la palabra a modificar");
        String palabra = scanner.nextLine();
        System.out.println("Itroduce la nueva definición de " + palabra);
        String definicion = scanner.nextLine();
        diccionario.set(palabra, definicion);
    }

    /**
     * Eliminar una palabra y su definición del diccionario
     */
    private static void eliminarPalabra() {
        System.out.println("Introduce la palabra a añadir");
        String palabra = scanner.nextLine();
        diccionario.remove(palabra);
    }

    /**
     * Buscar una palabra y su definición en el diccionario
     */
    private static void consultarPalabra() {
        System.out.println("Introduce la palabra a buscar");
        String palabra = scanner.nextLine();
        diccionario.buscar(palabra);
    }
}
