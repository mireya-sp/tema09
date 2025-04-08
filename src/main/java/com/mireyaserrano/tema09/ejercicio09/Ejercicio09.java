package com.mireyaserrano.tema09.ejercicio09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio09 {
    public static Random random = new Random();

    private static Scanner scanner = new Scanner(System.in);

    private static Diccionario diccionario = new Diccionario();

    private static ArrayList<Integer> mejoresPuntuaciones = new ArrayList<>();
    private static int contador = 0;

    /**
     * El menú primcipal del programa
     */
    public static void menu(){
        System.out.println("*********************\n" +
                "* JUEGO DICCIONARIO *\n" +
                "*********************\n" +
                "1. Añadir palabra\n" +
                "2. Modificar palabra\n" +
                "3. Eliminar palabra\n" +
                "4. Consultar palabra\n" +
                "5. Mostrar diccionario\n" +
                "6. Jugar\n" +
                "7. Mejores puntuaciones\n" +
                "---------------------\n" +
                "0. Salir");
    }

    public static void main(String[] args){
        int opcion = 0;
        do {
            menu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> anyadirPalabra();
                case 2 -> modificarPalabra();
                case 3 -> eliminarPalabra();
                case 4 -> consultarPalabra();
                case 5 -> diccionario.getDiccionario();
                case 6 -> jugar();
                case 7 -> System.out.println();
                default -> System.out.println("Introduce una opción válida");
            }
        }while (opcion != 0);
    }

    /**
     * Añade palabras y su definición al diccionario
     */
    private static void anyadirPalabra() {
        System.out.println("Introduce la palabra a añadir");
        String palabra = scanner.nextLine();
        System.out.println("Itroduce la definición de " + palabra);
        String definicion = scanner.nextLine();
        diccionario.add(palabra, definicion);
    }

    /**
     * Modifica la definición de una palabra
     */
    private static void modificarPalabra() {
        System.out.println("Introduce la palabra a modificar");
        String palabra = scanner.nextLine();
        System.out.println("Itroduce la nueva definición de " + palabra);
        String definicion = scanner.nextLine();
        diccionario.set(palabra, definicion);
    }

    /**
     * Elimina la palabra y su definición del diccionario
     */
    private static void eliminarPalabra() {
        System.out.println("Introduce la palabra a eliminar");
        String palabra = scanner.nextLine();
        diccionario.remove(palabra);
    }

    /**
     * Busca la definición de una palabra en el diccionario
     */
    private static void consultarPalabra() {
        System.out.println("Introduce la palabra a buscar");
        String palabra = scanner.nextLine();
        diccionario.buscar(palabra);
    }

    public static List<String> definiciones;

    /**
     *
     */
    private static void jugar() {
        if (diccionario.size() == 0){
            System.out.println("No hay palabras en el diccionario");
            return;
        }
        definiciones = diccionario.getDefiniciones();
        boolean acierto;
        int aciertos = 0;
        do{
            int indiceRandom = random.nextInt(definiciones.size());
            String pregunta = definiciones.get(indiceRandom);
            System.out.print("Introduce la palabra a la que corresponde esta definición: ");
            System.out.println(pregunta);
            String guess = scanner.nextLine();
            acierto = pregunta.contentEquals(diccionario.buscar(guess));
            if (acierto){
                aciertos++;
            }else {
                mejoresPuntuaciones.set(contador, aciertos);
                contador++;
                System.out.println("Fallaste, suerte en la próxima");
            }
        }while (acierto);
    }
}
