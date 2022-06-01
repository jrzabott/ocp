package com.ocp.chapter7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Concurrency04ScheduledES {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(printHello(), 2, 2, TimeUnit.SECONDS);

        List<Integer> waitingTime = new ArrayList<>();
        while (counter < 10) {
            final long nextTimeout = getNextTimeout(waitingTime);
            System.out.println("Counter: " + counter + " - Waiting time: " + nextTimeout);
            waitFor(nextTimeout);
        }
        System.out.println("Finished Counter: " + counter);
        service.shutdown();
    }

    private static void waitFor(long nextTimeout) throws InterruptedException {
        Thread.sleep(nextTimeout);
    }

    private static long getNextTimeout(List<Integer> waitingTime) {
        long result ;
        if (waitingTime.isEmpty() || waitingTime.size() == 1) {
            waitingTime.add(1);
            result = 1;
        } else {
            final int sum = waitingTime.get(waitingTime.size() - 1) + waitingTime.get(waitingTime.size() - 2);
            waitingTime.add(sum);
            result = sum;
        }
        return result * 1000;
    }

    private static Runnable printHello() {
        return () -> {
            System.out.println(LocalDateTime.now() + " - Hello");
            counter++;
        };
    }
}
