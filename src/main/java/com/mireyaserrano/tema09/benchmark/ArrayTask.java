package com.mireyaserrano.tema09.benchmark;

import java.util.Random;

public class ArrayTask implements Ejecutable{
    @Override
    public void start(int size, int times, int seekValue, Random random) {
        //random.setSeed(System.nanoTime());
        int[] datos = new int[size];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < datos.length; j++) {
                datos[j] = random.nextInt();
            }
        }

        for (int i = 0; i < times; i++) {
            for (int dato : datos) {
                if (dato == seekValue) {
                    return;
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "Array VS ArrayList";
    }
}
