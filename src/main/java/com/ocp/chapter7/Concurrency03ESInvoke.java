package com.ocp.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Concurrency03ESInvoke {
    public static final int SECOND_IN_MILLIS = 1000;
    public static final Predicate<Future<String>> NOT_CANCELLED_TASK = future -> future.isDone() && !future.isCancelled();
    Callable<String> c1 = () -> {
        final long sleepTime = getSleepTime();
        System.out.println("c1 will sleep for " + sleepTime + " ms");
        Thread.sleep(sleepTime);
        return "Callable C1 Result";
    };
    Callable<String> c2 = () -> {
        final long sleepTime = getSleepTime();
        System.out.println("c2 will sleep for " + sleepTime + " ms");
        Thread.sleep(sleepTime);
        return "Callable C2 Result";
    };
    Callable<String> c3 = () -> {
        final long sleepTime = getSleepTime();
        System.out.println("c3 will sleep for " + sleepTime + " ms");
        Thread.sleep(sleepTime);
        return "Callable C3 Result";
    };
    List<Callable<String>> callables = Arrays.asList(c1, c2, c3);

    public static void main(String[] args) {
        Concurrency03ESInvoke myClass = new Concurrency03ESInvoke();

        ExecutorService service = null;
        List<Future<String>> all = null;
        try {
            service = Executors.newSingleThreadExecutor();

            // invoke all callables in a list, and get the results
//            all = service.invokeAll(myClass.getCallables(), 10, TimeUnit.SECONDS);
//            all = service.invokeAll(myClass.getCallables());
//            all = myClass.getCallables().stream().map(service::submit).collect(Collectors.toList());
            all = Arrays.asList(service.submit(myClass.getC1()), service.submit(myClass.getC2()), service.submit(myClass.getC3()));
            /*
             * Funny Fact not matter the submission format, all the threads will be invoked and we will have to wait for
             * them all. The method submit(), also starts the thread. =/
             */


            // get results individually and print them on the screen.
//            all.forEach(getFuturesResults());


//        } catch (InterruptedException e) {
//            printExceptionMsg(e);
//            Thread.currentThread().interrupt();
        } catch (CancellationException e) {
            System.out.println("Execution cancelled: " + e.getMessage());
        } finally {
            if (service != null) service.shutdown();
            printNotCancelledTasks(all);
        }

        try {
            if (service != null) {
                service.awaitTermination(1, TimeUnit.MINUTES);
                if (service.isTerminated()) {
                    System.out.println("All tasks completed");
                } else {
                    System.out.println("Not all tasks completed");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
// kept for historical reasons
    private static Consumer<Future<String>> getFuturesResults() {
        return future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                printExceptionMsg(e);
                Thread.currentThread().interrupt();
            }
        };
    }

    private static void printExceptionMsg(Exception e) {
        System.out.println("Exception: " + e.getClass() + " - " + e.getMessage());
    }

    private static void printNotCancelledTasks(List<Future<String>> all) {
        if (all != null) {

            all.stream().filter(NOT_CANCELLED_TASK).forEach(future -> {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    Thread.currentThread().interrupt();
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            });
        } else {
            System.out.println("No tasks were completed.");
        }

    }

    public Callable<String> getC1() {
        return c1;
    }

    public Callable<String> getC2() {
        return c2;
    }

    public Callable<String> getC3() {
        return c3;
    }

    public List<Callable<String>> getCallables() {
        return callables;
    }

    private long getSleepTime() {
        return (long) (Math.random() * SECOND_IN_MILLIS * 100);
    }
}
