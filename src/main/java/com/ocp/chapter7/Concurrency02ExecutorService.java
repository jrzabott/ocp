package com.ocp.chapter7;

import java.util.concurrent.*;

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

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // create an ExecutorService
        ExecutorService service = null;
        try {
            // create a single thread pool
            service = Executors.newSingleThreadExecutor();

            final Future<?> resultOfShortTask = service.submit(aShortTask);
            final Future<?> resultOfLongTask = service.submit(aLongTask);

            // check if the task is done
            resultOfShortTask.get(1, TimeUnit.SECONDS);
            resultOfLongTask.get(6, TimeUnit.SECONDS);
            System.out.println("All done.");

        } finally {
            if (service != null) service.shutdown();
        }

    }
}
