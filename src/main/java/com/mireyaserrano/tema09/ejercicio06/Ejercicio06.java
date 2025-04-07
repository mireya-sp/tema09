package com.mireyaserrano.tema09.ejercicio06;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio06 {
    private static Scanner scanner = new Scanner(System.in);

    private static ParejasPalabras parejas = new ParejasPalabras();

    /**
     * El menú principal del programa
     */
    public static void menu() {
        System.out.println("MENÚ PRINCIPAL\n" +
                "==============\n" +
                "1. Introducir parejas de palabras.\n" +
                "2. Traducir palabras.\n" +
                "0. Salir de la aplicación.\n");
    }

    public static void main(String[] args) {
        int opcion = 0;
        do {
            menu();
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0 -> System.out.println("Saliendo...");
                case 1 -> introducirParejas();
                case 2 -> traducirPalabras();
                default -> System.out.println("Por favor introduce una opcioón válida");
            }

        } while (opcion != 0);
    }

    /**
     * Método con el que se introducen parejas de palabras de inglés y valenciano
     */
    public static void introducirParejas() {
        System.out.print("¿Cuántas parejas deseas introducir? ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce palabra en inglés: ");
            String palabraIn = scanner.nextLine();
            System.out.print("Introduce traducción al valenciano: ");
            String palabraVal = scanner.nextLine();
            parejas.add(palabraIn, palabraVal);
        }
    }

    /**
     * Metodo que busca la palabra en ingles en el Map mediante la key y devuelve la palabra en valenciano si existe
     */
    private static void traducirPalabras() {
        System.out.print("Palabra a buscar: ");
        String palabraIn = scanner.nextLine();
        try {
            if (parejas.buscar(palabraIn).equals(null)) {
                System.out.println("");
            } else {
                System.out.println(parejas.buscar(palabraIn));
            }
        }catch (NullPointerException npe){
            System.out.println("No tenemos esa palabra en el diccionario");
        }
    }
}
