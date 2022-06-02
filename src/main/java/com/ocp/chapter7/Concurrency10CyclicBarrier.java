package com.ocp.chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency10CyclicBarrier {
    /*
    Let's use our Zoo example.
    Let's suppose 4 pen managers have to clean the Lion's pen. Oviously, they can't do that, while the lion in inside.
    How to represent this limitation using a CyclicBarrier?
     */
    public static void main(String[] args) throws InterruptedException {
        LionPenManager manager = new LionPenManager();
        CyclicBarrier removeAnimals = new CyclicBarrier(4);
        CyclicBarrier cleanPen = new CyclicBarrier(4, () -> System.out.println("Lion's pen is clean"));

        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            service.submit(() -> manager.performTasks(removeAnimals, cleanPen));
        }

        Thread.sleep(1000);
        System.out.println("Rest a little...");
        Thread.sleep(1000);
        System.out.println("Resuming...");
        for (int i = 0; i < 4; i++) {
            service.submit(() -> manager.performTasks(removeAnimals, cleanPen));
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

    public void performTasks(CyclicBarrier barrier1, CyclicBarrier barrier2) {

        try {
            removeAnimals();
            barrier1.await();
            cleanPen();
            barrier2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}