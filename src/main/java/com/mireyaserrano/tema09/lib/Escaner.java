package com.mireyaserrano.tema09.lib;

import java.util.Scanner;

public class Escaner {
    public final static Scanner lector = new Scanner(System.in);
    public static void dispose(){
        lector.close();
    }
}
