package com.mireyaserrano.tema09.ejercicio07;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio07 {
    private static Map<String, Double> mapita = new HashMap<>();

    public static void main(String[] args){
        mapita.put("USD", 0.91);
        mapita.put("GBP", 1.19);
        mapita.put("INR", 0.011);
        mapita.put("AUD", 0.57);
        mapita.put("CAD", 0.64);
        mapita.put("ARS", 0.00084);
        mapita.put("BOB", 0.017);
        mapita.put("CLP", 0.00084);
        mapita.put("VEZ", 0.00022);
        mapita.put("CRC", 0.0018);
        mapita.put("CUP", 0.038);
        mapita.put("DOP", 0.014);
        mapita.put("MXN", 0.045);

        System.out.println(mapita);
    }
}
