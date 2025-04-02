package com.mireyaserrano.tema09.Map;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.*;

public class AgendaContactos {
    private final Map<String, Contacto> contactosMap;

    public AgendaContactos(){
        contactosMap = new HashMap<>(100);
    }

    public void add(Contacto contacto) throws KeyAlreadyExistsException{
        if (contactosMap.containsKey(contacto.getNumero())){
            throw new KeyAlreadyExistsException("Ya existe un contacto asociado a " + contacto.getNumero());
        }
        contactosMap.put(contacto.getNumero(), contacto);
    }

    public void set(Contacto contacto){
        if (contactosMap.containsKey(contacto.getNumero())){
            contactosMap.put(contacto.getNumero(), contacto);
        }else {
            throw new RuntimeException("No existe ningún contacto asociado a el número " + contacto.getNumero());
        }
    }

    public Contacto buscar(String numero){
        return contactosMap.get(numero);
    }

    public List<Contacto> getContactos() {
        //return contactosMap.values().stream().toList();
        List<Contacto> contactos = new ArrayList<>(contactosMap.values().size());
        for (Contacto contacto : contactosMap.values()) {
            contactos.add(contacto);
        }
        return contactos;
    }

    public Set<String> getTelefonos(){
        return contactosMap.keySet();
    }

    public String getAgenda(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Contacto> pareja: contactosMap.entrySet()){
            sb.append("Tel: ").append(pareja.getKey());
            sb.append(", Contacto: ").append(pareja.getValue()).append("\n");
        }
        return sb.toString();
    }
}
