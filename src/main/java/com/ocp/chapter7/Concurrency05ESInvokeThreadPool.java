package com.ocp.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Concurrency05ESInvokeThreadPool {
    public static final int SECOND_IN_MILLIS = 1000;
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
    List<Callable<String>> callables = Arrays.asList(getC1(), getC2(), getC3());

    public static void main(String[] args) throws InterruptedException {
        Concurrency05ESInvokeThreadPool myClass = new Concurrency05ESInvokeThreadPool();

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            myClass.getCallables().forEach(service::submit);
        } finally {
            System.out.println("Shutting down executor service");
            if (service != null) service.shutdown();
        }

        System.out.println("Waiting for tasks to complete... ");
        service.awaitTermination(1, TimeUnit.MINUTES);
        if (service.isTerminated()) {
            System.out.println("All tasks completed");
        } else {
            System.out.println("Not all tasks completed");
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
