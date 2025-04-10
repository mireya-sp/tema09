package com.mireyaserrano.tema09.benchmark;

public class MainBenchmark {
    public static void main(String[] args){
        Ejecutable array = new ArrayTask();
        Ejecutable arrayList = new ArrayListTask();
        Benchmark benchmark = new Benchmark(1_000_000, 10, 10);
        benchmark.addEjecutable(array);
        benchmark.addEjecutable(arrayList);
        benchmark.iniciar();
        System.out.println(benchmark);
    }
}
