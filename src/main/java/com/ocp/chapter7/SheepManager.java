package com.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {

    private static final Object lock = new Object();
    private AtomicInteger sheepCountAtomic = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        SheepManager manager = new SheepManager();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                executor.submit(manager::incrementAndReport);
            }
            synchronized (lock) {
                System.out.println();
                manager.sheepCountAtomic.set(0);
            }
        }
        executor.shutdown();
        executor.awaitTermination(1, java.util.concurrent.TimeUnit.DAYS);
    }


    private void incrementAndReport() {
        synchronized (lock) {
            System.out.print(sheepCountAtomic.incrementAndGet() + " ");
        }
    }
}
