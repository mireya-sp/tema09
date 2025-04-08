package com.mireyaserrano.tema09.ejercicio10;

import com.mireyaserrano.tema09.lib.Escaner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Ejercicio10 {
    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Empleado> plantilla = new ArrayList<>();

    public static void menu(){
        System.out.println("*********************\n" +
                "* GESTIÓN EMPLEADOS *\n" +
                "*********************\n" +
                "1. Nuevo empleado\n" +
                "2. Nuevo hijo\n" +
                "3. Modificar sueldo\n" +
                "4. Borrar empleado\n" +
                "5. Borrar hijo\n" +
                "6. Consultas\n" +
                "---------------------\n" +
                "0. Salir");
    }

    public static void menuConsultas(){
        System.out.println("***********************\n" +
                "* CONSULTAS EMPLEADOS *\n" +
                "***********************\n" +
                "1. Buscar por NIF\n" +
                "2. Buscar por nombre\n" +
                "3. Buscar por rango de edad.\n" +
                "4. Buscar por rango de sueldo.\n" +
                "5. Buscar por hijos menores de edad\n" +
                "-----------------------------\n" +
                "0. Volver al menú principal\n");
    }


    public static void main(String[] args){
        int opcion;
        do {
            menu();
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> nuevoEmpleado();
                case 2 -> nuevoHijo();
                case 3 -> modificarSueldo();
                case 4 -> System.out.println(borrarEmpleado());
                case 5 -> System.out.println(borrarHijo());
                case 6 -> consultas();
                default -> System.out.println("Introduce una opción válida por favor");
            }
        }while (opcion != 0);
    }

    public static void consultas(){
        int opcion;
        do {
            menuConsultas();
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Volviendo al menú...");
                case 1 -> {try {
                    System.out.println(buscarNIF());
                }catch (NoSuchElementException nsee){
                    System.out.println(nsee.getMessage());
                }
                }
                case 2 -> System.out.println(buscarNombre());
                case 3 -> System.out.println(buscarEdad());
                case 4 -> System.out.println(buscarSueldo());
                case 5 -> System.out.println(buscarHijos());
                default -> System.out.println("Introduce una opción válida por favor");
            }
        }while (opcion != 0);
    }

    private static void nuevoEmpleado(){
        String dni;
        String nombre;
        String apellidos;
        String fechaNacimientoString;
        LocalDate fechaNacimiento = null;
        ArrayList<Hijo> hijos = new ArrayList<>();
        int sueldo;
        boolean validado = false;
        do {//DNI
            System.out.println("DNI: ");
            dni = scanner.nextLine().trim();
            if (dni.length() == 9){
                for (int i = 0; i < dni.length(); i++) {
                    if (Character.isDigit(dni.charAt(i)) && i < dni.length()-1){
                        validado = true;
                    } else if (Character.isLetter(dni.charAt(i)) && i != dni.length()-1) {
                        validado = false;
                    }
                }
            }
            if (!validado) {
                System.out.println("El DNI debe tener 8 números y una letra ");
                continue;
            }
            validado = buscarEmpleadoPorNIF(dni) == null;
            if (!validado) {
                System.out.println("El DNI introducido ya pertenece a un empleado");
                System.out.println("Introduzca otro por favor");
            }
        } while (!validado);

        do {//Nombre
            System.out.println("Nombre: ");
            nombre = scanner.nextLine();
            validado = nombre.length() > 2;
            if (!validado) {
                System.out.println("Nombre debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {//Apellidos
            System.out.println("Apellidos: ");
            apellidos = scanner.nextLine();
            validado = apellidos.length() > 2;
            if (!validado) {
                System.out.println("Apellidos debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {//Fecha nacimiento
            System.out.println("Fecha nacimiento (dd/mm/yyyy): ");
            fechaNacimientoString = scanner.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoString, dateTimeFormatter);
                validado = true;
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha de nacimiento no es válido. Recuerde (dd-mm-yyyy).");
            }
        } while (!validado);

        do {//Sueldo
            System.out.println("Sueldo: ");
            sueldo = Integer.parseInt(scanner.nextLine());
            validado = sueldo < 4500;
            if (!validado){
                System.out.println("Tu estás pidiendo mucho eh");
            }
        } while (!validado);

        System.out.println("Cuantos hijos vas a añadir??");
        int cantidadHijos = Integer.parseInt(scanner.nextLine());
        if (cantidadHijos > 0) {
            do {
                hijos.add(nuevoHijo());
                cantidadHijos--;
            } while (cantidadHijos > 0);
        }
        if (plantilla.add(new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo, hijos))) {
            System.out.println("Empleado guardado correctamente");
        } else {
            System.out.println("Imposible añadir el empleado.");
        }

    }

    private static Hijo nuevoHijo(){
        String nombreHijo;
        String fechaNacimientoString;
        LocalDate fechaNacimientoHijo = null;
        boolean validado;
        do {
            System.out.println("Nombre: ");
            nombreHijo = scanner.nextLine();
            validado = nombreHijo.length() > 2;
            if (!validado) {
                System.out.println("Nombre debe tener almenos 2 caracteres");
            }
        } while (!validado);
        do {
            System.out.println("Fecha nacimiento (dd/mm/yyyy): ");
            fechaNacimientoString = scanner.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                fechaNacimientoHijo = LocalDate.parse(fechaNacimientoString, dateTimeFormatter);
                validado = true;
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha de nacimiento no es válido. Recuerde (dd/mm/yyyy).");
            }
        } while (!validado);
        return new Hijo(nombreHijo, fechaNacimientoHijo);
    }

    private static Empleado buscarEmpleadoPorNIF(String dni) {
        int posicion = buscarPosicionEmpleado(dni);
        return posicion >= 0 ? plantilla.get(posicion) : null;
    }

    private static int buscarPosicionEmpleado(String dni) {
        int i;
        for (i = 0; i < plantilla.size(); i++) {
            if (plantilla.get(i).getDNI().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    private static Empleado buscarNIF(){
        String dni;
        boolean validado = false;
        do {//DNI
            System.out.println("DNI: ");
            dni = scanner.nextLine().trim();
            if (dni.length() == 9){
                for (int i = 0; i < dni.length(); i++) {
                    if (Character.isDigit(dni.charAt(i)) && i < dni.length()-1){
                        validado = true;
                    } else if (Character.isLetter(dni.charAt(i)) && i != dni.length()-1) {
                        validado = false;
                    }
                }
            }
            if (!validado) {
                System.out.println("El DNI debe tener 8 números y una letra ");
                continue;
            }
            validado = buscarEmpleadoPorNIF(dni) != null;
            if (!validado) {
                System.out.println("El DNI introducido no pertenece a ningún empleado");
                System.out.println("Introduzca otro por favor");
            }
        } while (!validado);
        return buscarEmpleadoPorNIF(dni);
    }

    private static void modificarSueldo(){
        Empleado empleado = buscarNIF();
        System.out.println("Introduce el nuevo sueldo para el epmleado");
        int suledo = Integer.parseInt(scanner.nextLine());
        empleado.setSueldo(suledo);
    }

    private static Empleado borrarEmpleado(){
        Empleado empleado = buscarNIF();
        plantilla.remove(empleado);
        return empleado;
    }

    private static Hijo borrarHijo(){
        Empleado empleado = buscarNIF();
        System.out.println("Nombre del hijo a borrar");
        String nombreHijo = scanner.nextLine();
        return empleado.removeHijo(nombreHijo);
    }

    private static ArrayList<Empleado> buscarNombre(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        System.out.println("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        for (int i = 0; i < plantilla.size(); i++) {
            if (plantilla.get(i).getNombre().equals(nombre)){
                empleados.add(plantilla.get(i));
            }
        }
        return empleados;
    }

    private static ArrayList<Empleado> buscarEdad(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        System.out.println("Introduce la edad mínima:");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce la edad máxima");
        int max = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < plantilla.size(); i++) {
            if (plantilla.get(i).getEdad() >= min && plantilla.get(i).getEdad() <= max){
                empleados.add(plantilla.get(i));
            }
        }
        return empleados;
    }

    private static ArrayList<Empleado> buscarSueldo(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        System.out.println("Introduce el sueldo mínimo:");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el sueldo máximo");
        int max = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < plantilla.size(); i++) {
            if (plantilla.get(i).getSueldo() >= min && plantilla.get(i).getSueldo() <= max){
                empleados.add(plantilla.get(i));
            }
        }
        return empleados;
    }

    private static ArrayList<Empleado> buscarHijos(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        for (int i = 0; i < plantilla.size(); i++) {
            for (int j = 0; j < plantilla.get(i).getHijos().size(); j++) {
                if (plantilla.get(i).getHijos().get(j).getEdad() < 18) {
                    empleados.add(plantilla.get(i));
                }
            }
        }
        return empleados;
    }
}
