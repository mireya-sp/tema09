package com.mireyaserrano.tema09.ejercicio11;

import java.util.ArrayList;
import java.util.Arrays;

public class CentroEducativo {

    private final String codigo;
    private final ArrayList<Alumno> alumnos;
    private final ArrayList<Grupo> grupos;
    private final ArrayList<Aula> aulas;
    private final ArrayList<Asignatura> asignaturas;
    private final ArrayList<Profesor> profesores;

    public CentroEducativo(String codigo) {
        this.codigo = codigo;
        alumnos = new ArrayList<>();
        grupos = new ArrayList<>();
        aulas = new ArrayList<>();
        asignaturas = new ArrayList<>();
        profesores = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public boolean nuevoAlumno(String nombre, Grupo grupo) {
        return alumnos.add(new Alumno(nombre, grupo));
    }

    public boolean nuevaAsignatura(int codigo, String nombre, Profesor profesor){
        for (int i = 0; i < asignaturas.size(); i++) {
            if (asignaturas.get(i).getCodigo() == codigo){
                return false;
            }
        }
        return asignaturas.add(new Asignatura(codigo, nombre, profesor));
    }

    public boolean nuevoGrupo(int codigo, String nombre, Aula aula){
        if (buscarGrupoPorCodigo(codigo) == null){
            return grupos.add(new Grupo(codigo, nombre, aula));
        }
        return false;
    }

    public int nuevaAula(int codigo, double metrosCuadrados){
        int posicion;
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getCodigo() == codigo){
                return -1;
            }
        }
        posicion = aulas.size();
        aulas.add(new Aula(codigo, metrosCuadrados));
        return posicion;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param sueldo
     * @return La posición en la se guarda el profe
     */
    public boolean nuevoProfesor(String dni, String nombre, int sueldo){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)){
                return false;
            }
        }
        return profesores.add(new Profesor(dni, nombre, sueldo));

    }

    public boolean bajaAlumno(int id) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getIdAlumno() == id){
                alumnos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Alumno buscarAlumnoPorId(int id) {
        int posicion = buscarPosicionAlumno(id);
        return posicion >= 0 ? alumnos.get(posicion) : null;
    }

    private int buscarPosicionAlumno(int id) {
        int i;
        for (i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getIdAlumno() == id) {
                return i;
            }
        }
        return -1;
    }

    public Alumno[] buscarAlumnosPorGrupo(int codigoGrupo) {
        ArrayList<Alumno> alumnosGrupo = new ArrayList<>();
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getGrupo().getCodigo() == codigoGrupo) {
                alumnosGrupo.add(alumnos.get(i));
            }
        }
        return alumnosGrupo.toArray(Alumno[]::new);
    }

    public Alumno[] buscarAlumnosPorProfesor(String dniProfe){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        for (int i = 0; i < alumnos.size(); i++) {
            for (int j = 0; j < alumnos.get(i).getAsignaturas().size(); j++) {
                if (alumnos.get(i).getAsignaturas().get(j).getProfesor().getDni().equals(dniProfe)) {
                    alumnos.add(alumnos.get(i));
                }
            }
        }
        return alumnos.toArray(Alumno[]::new);
    }

    public Grupo buscarGrupoPorCodigo(int codigo) {
        for (Grupo grupo : grupos) {
            if (grupo.getCodigo() == codigo) return grupo;
        }
        return null;
    }

    public Asignatura buscarAsignaturaPorCodigo(int codigo){
        for (int i = 0; i < asignaturas.size(); i++){
            if (asignaturas.get(i).getCodigo() == codigo){
                return asignaturas.get(i);
            }
        }
        return null;
    }

    public Profesor buscarProfesorPorDNI(String dni){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)){
                return profesores.get(i);
            }
        }
        return null;
    }

    public String listadoAlumnos() {
        StringBuilder sb = new StringBuilder();
        // Mostrar todos los alumnos
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i) != null) {
                sb.append(alumnos.get(i).toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String listadoGrupos() {
        StringBuilder sb = new StringBuilder();
        for (Grupo grupo : grupos) {
            sb.append(grupo.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CentroEducativo that)) return false;

        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return "CentroEducativo{" +
                "codigo='" + codigo + '\'' +
                ", alumnos=" + alumnos +
                ", grupos=" + grupos +
                ", aulas=" + aulas +
                ", asignaturas=" + asignaturas +
                ", profesores=" + profesores +
                '}';
    }
}
