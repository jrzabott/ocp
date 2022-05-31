package com.ocp.chapter7;

import java.util.concurrent.*;

public class Concurrency02ExecutorService {

    // submitting a long running task
    private static Runnable aLongRunnable = () -> {
        try {
            Thread.sleep(5000);
            System.out.println("After 5 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    };

    // submit a simple task
    private static Runnable aShortRunnable = () -> System.out.println("Hello");

    private static Callable<Integer> aShortCallable = () -> 30+11+92;
    private static Callable<Integer> aLongCallable = () -> {
        Thread.sleep(2000);
        return 30+11+92;
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        playWithCallable();
        playWithRunnable();
    }

    private static void playWithCallable() throws InterruptedException, ExecutionException, TimeoutException {
        // create an ExecutorService
        ExecutorService service = null;
        try {
            // create a single thread pool
            service = Executors.newSingleThreadExecutor();

            final Future<?> resultOfShortTask = service.submit(aShortCallable);
            final Future<?> resultOfLongTask = service.submit(aLongCallable);

            // check if the task is done
            System.out.println(resultOfShortTask.get(1, TimeUnit.SECONDS));
            for (int i = 0; i < 20; i++) {
                System.out.println(resultOfLongTask.get(2, TimeUnit.SECONDS));
                System.out.println("All done.");
            }

        } finally {
            if (service != null) service.shutdown();
        }
    }

    private static void playWithRunnable() throws InterruptedException, ExecutionException, TimeoutException {
        // create an ExecutorService
        ExecutorService service = null;
        try {
            // create a single thread pool
            service = Executors.newSingleThreadExecutor();

            final Future<?> resultOfShortTask = service.submit(aShortRunnable);
            final Future<?> resultOfLongTask = service.submit(aLongRunnable);

            // check if the task is done
            resultOfShortTask.get(1, TimeUnit.SECONDS);
            resultOfLongTask.get(6, TimeUnit.SECONDS);
            System.out.println("All done.");

        } finally {
            if (service != null) service.shutdown();
        }
    }
}
