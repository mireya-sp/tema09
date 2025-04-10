package com.mireyaserrano.tema09.benchmark;

import java.util.Random;

public interface Ejecutable {
    void start(int size, int times, int seekValue, Random random);
    String getDescription();
}
