package com.ocp.chapter7;

public class CheckResults {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        final Runnable runnable = () -> {
            for (int i = 0; i < 500000000; i++) {
                counter++;
            }
        };

        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
            while (counter < 1000) {
                System.out.println("Counter: " + counter + "... Smaller than 100");
                Thread.sleep(100);
            }
            System.out.println("Counter: " + counter + "... >= to 100");
            counter = 0;
        }
    }

}

