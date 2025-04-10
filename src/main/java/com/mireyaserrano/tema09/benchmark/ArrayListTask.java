package com.mireyaserrano.tema09.benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListTask implements Ejecutable{
    @Override
    public void start(int size, int times, int seekValue, Random random) {
        //random.setSeed(System.nanoTime());
        List<Integer> datos = new ArrayList<>(size);
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < size; j++) {
                datos.add(random.nextInt());
            }
            datos.clear();
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
