package com.mireyaserrano.tema09.ejercicio06;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.*;

public class ParejasPalabras {
    private final Map<String, String> palabrasMap;

    public ParejasPalabras(){
        palabrasMap = new HashMap<>();
    }

    public void add(String palabraIn, String palabraVal) throws KeyAlreadyExistsException {
        if (palabrasMap.containsKey(palabraIn)){
            throw new KeyAlreadyExistsException("Ya existe una palabra asociada a " + palabraIn);
        }
        palabrasMap.put(palabraIn, palabraVal);
    }

    public void set(String palabraIn, String palabraVal){
        if (palabrasMap.containsKey(palabraIn)){
            palabrasMap.put(palabraIn, palabraVal);
        }else {
            throw new RuntimeException("No existe " + palabraIn + " en el diccionario");
        }
    }

    public String buscar(String palabra) {
        return palabrasMap.get(palabra);
    }

    public List<String> getPalabras() {
        List<String> palabras = new ArrayList<>(palabrasMap.values().size());
        for (String palabra : palabrasMap.values()) {
            palabras.add(palabra);
        }
        return palabras;
    }

    public Set<String> getPalabra(){
        return palabrasMap.keySet();
    }

    public String getAgenda(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pareja: palabrasMap.entrySet()){
            sb.append("Palabra inglés: ").append(pareja.getKey());
            sb.append(", Palabra valenciano: ").append(pareja.getValue()).append("\n");
        }
        return sb.toString();
    }
}
