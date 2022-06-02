package com.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency10CyclicBarrier {
    /*
    Let's use our Zoo example.
    Let's suppose 4 pen managers have to clean the Lion's pen. Oviously, they can't do that, while the lion in inside.
    How to represent this limitation using a CyclicBarrier?
     */
    public static void main(String[] args) {
        LionPenManager manager = new LionPenManager();
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            service.submit(manager::performTasks);
        }
        service.shutdown();
    }


}

class LionPenManager {
    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTasks() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }
}