package com.mireyaserrano.tema09.ejercicio11;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static CentroEducativo centroEducativo = new CentroEducativo("1");

    private static void menu(){
        System.out.println("***********************\n" +
                "* GESTION CENTRO EDUCATIVO *\n" +
                "***********************\n" +
                "1. Alta de alumnos\n" +
                "2. Alta de asignaturas\n" +
                "3. Alta de grupos\n" +
                "4. Alta de aulas\n" +
                "5. Alta de profesores\n" +
                "6. Mostrar alumnos por grupo \n" +
                "7. Mostrar alumnos por profesor\n" +
                "-----------------------------\n" +
                "0. Salir\n");
    }

    public static void main(String[] args){
        int opcion;
        do {
            menu();
            System.out.println("Elige una opción");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> altaAlumno();
                case 2 -> altaAsignatura();
                case 3 -> altaGrupo();
                case 4 -> altaAula();
                case 5 -> System.out.println(altaProfesor());
                case 6 -> porgrupo();
                case 7 -> porProfesor();
                default -> System.out.println("Introduce una opción válida por favor");
            }
        }while (opcion != 0);
    }

    private static void altaAlumno(){
        boolean validado = false;
        String nombre;
        Grupo grupo = null;
        System.out.println("*** NUEVO ALUMNO ***" );
        do {
            System.out.println("Nombre: ");
            nombre = scanner.nextLine();
            validado = nombre.length() > 2;
            if (!validado) {
                System.out.println("Nombre debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {
            System.out.println(centroEducativo.listadoGrupos());
            System.out.println("Código del grupo: ");
            int codigo = Integer.parseInt(scanner.nextLine());
            grupo = centroEducativo.buscarGrupoPorCodigo(codigo);
            validado = grupo != null;
            if (!validado) {
                System.out.println("El código de grupo indicado no corresponde a ningún grupo");
            }
        } while (!validado);

        if (centroEducativo.nuevoAlumno(nombre, grupo)){
            System.out.println("Alumno guardado correctamente");
        } else {
            System.out.println("Imposible añadir el alumno.");
        }
    }

    private static void altaAsignatura(){
        boolean validado = false;
        int codigo;
        Profesor profesor;
        String nombre;
        Asignatura asignatura;
        int posicionProfe = -1;
        System.out.println("*** NUEVOA ASIGNATURA ***" );

        do {
            profesor = altaProfesor();
        }while (!validado);

        do {
            System.out.println("Nombre de la asignatura: ");
            nombre = scanner.nextLine();
            validado = nombre.length() > 2;
            if (!validado) {
                System.out.println("Nombre debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {
            System.out.println(centroEducativo.listadoGrupos());
            System.out.println("Código de la asignatura: ");
            codigo = Integer.parseInt(scanner.nextLine());
            asignatura = centroEducativo.buscarAsignaturaPorCodigo(codigo);
            validado = asignatura == null;
            if (!validado) {
                System.out.println("El código de la asignatura ya está asignado");
            }
        } while (!validado);

        if (centroEducativo.nuevaAsignatura(codigo, nombre, profesor)) {
            System.out.println("Asignatura guardada correctamente");
        } else {
            System.out.println("Imposible añadir la asignatura.");
        }
    }

    private static void altaGrupo(){
        boolean validado;
        int codigo;
        int codigoAula;
        double metrosAula;
        String nombre;
        Grupo grupo;
        int posicionAula = -1;
        System.out.println("*** NUEVO GRUPO ***" );

        System.out.println("Introduce el codigo de la aula del grupo");
        codigoAula = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < centroEducativo.getAulas().size(); i++) {
            if (centroEducativo.getAulas().get(i).getCodigo() == codigoAula) {
                posicionAula = i;
            }
        }
        if (posicionAula == -1){
            System.out.println("Metros cuadrados del aula: ");
            metrosAula = Double.parseDouble(scanner.nextLine());
            posicionAula = centroEducativo.nuevaAula(codigoAula, metrosAula);
        }


        do {
            System.out.println("Nombre del grupo: ");
            nombre = scanner.nextLine();
            validado = nombre.length() > 2;
            if (!validado) {
                System.out.println("Nombre debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {
            System.out.println(centroEducativo.listadoGrupos());
            System.out.println("Código del grupo: ");
            codigo = Integer.parseInt(scanner.nextLine());
            grupo = centroEducativo.buscarGrupoPorCodigo(codigo);
            validado = grupo == null;
            if (!validado) {
                System.out.println("El código del grupo ya está asignado");
            }
        } while (!validado);

        if (centroEducativo.nuevoGrupo(codigo, nombre, centroEducativo.getAulas().get(posicionAula))) {
            System.out.println("Grupo guardado correctamente");
        } else {
            System.out.println("Imposible añadir el grupo.");
        }
    }

    private static void altaAula(){
        int codigo;
        double metrosCuadrados;
        int posicionAula = -1;
        System.out.println("*** NUEVA AULA ***");
        System.out.println("Introduce el codigo de la aula del grupo");
        codigo = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < centroEducativo.getAulas().size(); i++) {
            if (centroEducativo.getAulas().get(i).getCodigo() == codigo) {
                posicionAula = i;
            }
        }
        if (posicionAula == -1){
            System.out.println("Metros cuadrados del aula: ");
            metrosCuadrados = Double.parseDouble(scanner.nextLine());
            posicionAula = centroEducativo.nuevaAula(codigo, metrosCuadrados);
        }

    }

    private static Profesor altaProfesor(){
        boolean validado = false;
        String dni;
        String nombre;
        int sueldo;
        int posicionProfe = -1;
        System.out.println("*** NUEVO PROFESOR ***");
        do {
            System.out.println("Introduce el DNI del profesor: ");
            dni = scanner.nextLine();
            if (dni.length() == 9) {
                for (int i = 0; i < dni.length(); i++) {
                    if (Character.isDigit(dni.charAt(i)) && i < dni.length() - 1) {
                        validado = true;
                    } else if (Character.isLetter(dni.charAt(i)) && i != dni.length() - 1) {
                        validado = false;
                    }
                }
            }
            if (!validado) {
                System.out.println("El DNI debe tener 8 números seguido de una letra mayusculas");
            }
        } while (!validado);

        if (centroEducativo.buscarProfesorPorDNI(dni) == null){
            do {
                System.out.println("Nombre del profesor: ");
                nombre = scanner.nextLine();
                validado = nombre.length() > 2;
                if (!validado) {
                    System.out.println("Nombre debe tener almenos 2 caracteres");
                }
            } while (!validado);
            do {
                System.out.println("Sueldo del profesor: ");
                sueldo = Integer.parseInt(scanner.nextLine());
                validado = sueldo < 4500;
                if (!validado) {
                    System.out.println("Tu estás pidiendo mucho eh");
                }
            } while (!validado);
            centroEducativo.nuevoProfesor(dni, nombre, sueldo);
            return centroEducativo.getProfesores().get(centroEducativo.getProfesores().size()-1);
        }
        return centroEducativo.buscarProfesorPorDNI(dni);
    }

    private static void porgrupo(){
        System.out.println("Introduce el codigo del grupo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.println(centroEducativo.buscarAlumnosPorGrupo(codigo).toString());
    }

    private static void porProfesor(){
        System.out.println("Introduce el DNI del profesor: ");
        String dni = scanner.nextLine();
        System.out.println(centroEducativo.buscarAlumnosPorProfesor(dni).toString());
    }
}
