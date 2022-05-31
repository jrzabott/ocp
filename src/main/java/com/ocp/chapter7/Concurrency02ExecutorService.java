package com.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Concurrency02ExecutorService {

    // submitting a long running task
    private static Runnable aLongTask = () -> {
        try {
            Thread.sleep(5000);
            System.out.println("After 5 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    };

    // submit a simple task
    private static Runnable aShortTask = () -> System.out.println("Hello");

    public static void main(String[] args) throws InterruptedException {
        // create an ExecutorService
        ExecutorService service = null;
        try {
            // create a single thread pool
            service = Executors.newSingleThreadExecutor();

            service.submit(aShortTask);
            final Future<?> result = service.submit(aLongTask);

            // check if the task is done
            while (true) {
                if (!result.isDone()) {
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
