package com.mireyaserrano.tema09.ejercicio08;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.*;

public class Diccionario {
    private final Map<String, String> diccionarioMap;

    public Diccionario(){
        diccionarioMap = new HashMap<>();
    }

    /**
     * Añadir palabras y su definición al diccionario
     * @param palabra La palabra a añadir
     * @param definicion La definición de la palabra
     * @throws KeyAlreadyExistsException
     */
    public void add(String palabra, String definicion) throws KeyAlreadyExistsException {
        if (diccionarioMap.containsKey(palabra)){
            throw new KeyAlreadyExistsException("Ya existe una palabra asociada a " + palabra);
        }
        diccionarioMap.put(palabra, definicion);
    }

    /**
     * Cambia la definición de una alabra en el diccionario
     * @param palabra La palabra a la que hay que cambiar la definición
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
     * Busca la definición de una palabra
     * @param palabra La palabra de la que queremos buscar la definición
     * @return La definición de la palabra
     */
    public String buscar(String palabra) {
        if (diccionarioMap.containsKey(palabra)) {
            return diccionarioMap.get(palabra);
        }else {
            System.out.println("La palabra que buscas no se encuentra en el diccionario");
        }
        return palabra;
    }

    public List<String> getPalabras() {
        List<String> palabras = new ArrayList<>(diccionarioMap.values().size());
        for (String palabra : diccionarioMap.values()) {
            palabras.add(palabra);
        }
        return palabras;
    }

    public Set<String> getPalabra(){
        return diccionarioMap.keySet();
    }

    public void remove(String palabra){
        if (diccionarioMap.containsKey(palabra)){
            diccionarioMap.remove(palabra);
        }else {
            System.out.println("No se encuentra esta palabra en el diccionario");
        }


    }

    /**
     * Recorre el diccionario y lo mete en el stringBuilder
     * @return el string con todos los datos del diccionario, listo para imprimirlo
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
