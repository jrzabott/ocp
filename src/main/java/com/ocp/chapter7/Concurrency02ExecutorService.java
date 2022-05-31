package com.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Concurrency02ExecutorService {
    public static void main(String[] args) throws InterruptedException {
        // create an ExecutorService
        ExecutorService service = null;
        try {
            // create a single thread pool
            service = Executors.newSingleThreadExecutor();

            // submit a simple task
            service.submit(() -> System.out.println("Hello"));

            // submitting a long running task
            final Future<?> submit = service.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("After 5 seconds");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            });


            // check if the task is done
            while (true) {
                if (!submit.isDone()) {
                    System.out.println("Waiting");
                    Thread.sleep(1000);
                } else {
                    break;
                }
            }
        } finally {
            if (service != null) service.shutdown();
        }

    }
}
