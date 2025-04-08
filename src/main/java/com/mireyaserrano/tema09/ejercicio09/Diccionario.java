package com.mireyaserrano.tema09.ejercicio09;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.*;

public class Diccionario {
    private final Map<String, String> diccionarioMap;

    public Diccionario(){
        diccionarioMap = new HashMap<>();
    }

    public int size(){return diccionarioMap.size();}

    /**
     * Añadir palabra y definición al diccionario
     * @param palabra La palabra a añadir
     * @param definicion La definición a añadir
     * @throws KeyAlreadyExistsException
     */
    public void add(String palabra, String definicion) throws KeyAlreadyExistsException {
        if (diccionarioMap.containsKey(palabra)){
            throw new KeyAlreadyExistsException("Ya existe una palabra asociada a " + palabra);
        }
        diccionarioMap.put(palabra, definicion);
    }

    /**
     * Cambiar la definición de una palabra del diccionario
     * @param palabra La palabra a la que se le cambia la definición
     * @param definicion La nueva definición de la palabra
     */
    public void set(String palabra, String definicion){
        if (diccionarioMap.containsKey(palabra)){
            diccionarioMap.put(palabra, definicion);
        }else {
            System.err.println("No exsiste " + palabra + " en el diccionario");;
        }
    }

    /**
     * Busca la definición de una palabra en el diccionario.
     * @param palabra La palabra de la cual hay que buscar la definición
     * @return La definición de la palabra
     */
    public String buscar(String palabra) {
        if (diccionarioMap.containsKey(palabra)) {
            return diccionarioMap.get(palabra);
        }else {
            System.out.println("La palabra que buscas no se encuentra en el diccionario");
        }
        return null;
    }

    /**
     * Recorre el diccionario y coge las definiciones
     * @return Todas las definiciones que hay en el diccionario
     */
    public List<String> getDefiniciones() {
        List<String> definiciones = new ArrayList<>(diccionarioMap.values().size());
        for (String definicion : diccionarioMap.values()) {
            definiciones.add(definicion);
        }
        return definiciones;
    }

    public Set<String> getPalabra(){
        return diccionarioMap.keySet();
    }

    /**
     * Elimina una palabra y su definición del diccionario
     * @param palabra La palabra a eliminar
     */
    public void remove(String palabra){
        if (diccionarioMap.containsKey(palabra)){
            diccionarioMap.remove(palabra);
        }else {
            System.out.println("No se encuentra esta palabra en el diccionario");
        }
    }

    /**
     * Recorre el diccionario entero y lo escribe en un StringBuilder
     * @return El StringBuilder toString del diccionario entero
     */
    public String getDiccionario(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pareja: diccionarioMap.entrySet()){
            sb.append("Palabra: ").append(pareja.getKey());
            sb.append(", Definicion: ").append(pareja.getValue()).append("\n");
        }
        return sb.toString();
    }
}
