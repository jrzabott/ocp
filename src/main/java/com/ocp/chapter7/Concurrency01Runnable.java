package com.ocp.chapter7;

public class Concurrency01Runnable {
    Runnable runnable01 = () -> System.out.println("Thread 1");
    Runnable runnable02 = () -> System.out.println("Thread 2");
    Runnable runnable03 = () -> {
        int i = 0;
        System.out.println("Thread 3. i begin: " + i);
        while (++i < 100) {
            //just increment i
        }

        System.out.println("Thread 3. i end: " + i);
    };

    public static void main(String[] args) {
        calculateAnAverage();
        tenTimesMyThreeThreads();
    }

    private static void calculateAnAverage() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        CalculateAverages ca = new CalculateAverages(array);
        Thread caThread = new Thread(ca);
        caThread.start();
    }

    private static void tenTimesMyThreeThreads() {
        for (int i = 0; i < 10; i++) {
            Concurrency01Runnable c = new Concurrency01Runnable();
            Thread thread01 = new Thread(c.runnable01);
            Thread thread02 = new Thread(c.runnable02);
            Thread thread03 = new Thread(c.runnable03);
            thread01.start();
            thread02.start();
            thread03.start();
            System.out.println("===============================");
        }
    }

}

