package com.ocp.other;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class RunTest {
    static class Runner implements Runnable {
        @Override
        public void run() {
            System.out.println("In run...");
        }
    }

    public static void main(String[] args) {
        Runner r = new Runner();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        Stream stream;
        Reader re = s-> System.out.println(s);
        Instant.now().truncatedTo(ChronoUnit.DAYS);

    }

    interface Reader {
        void unread(String s);
        default void read(String s){
            System.out.println(s);
        };
    }
}


