package com.mireyaserrano.tema09.Map;

import java.util.Objects;

public class Contacto {
    private final String numero;
    private final String nombre;
    private final String email;

    public Contacto(String numero, String nombre, String email) {
        this.numero = numero;
        this.nombre = nombre;
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(numero, contacto.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
