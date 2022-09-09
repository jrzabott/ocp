package com.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockExample {
    public static void main(String[] args) {
        Food food = new Food();
        Water water = new Water();
        Fox foxy = new Fox();
        Fox tails = new Fox();

        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

class Food {
}

class Water {
}

class Fox {
    private static final Object LOCK = new Object();

    public void eatAndDrink(Food food, Water water) {
        synchronized (LOCK) {
            synchronized (food) {
                System.out.println("Got Food!");
                move();
                synchronized (water) {
                    System.out.println("Got Water!");
                }
            }
        }
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized (LOCK) {
            synchronized (water) {
                System.out.println("Got Water!");
                move();
                synchronized (food) {
                    System.out.println("Got Food!");
                }
            }
        }
    }

    public void move() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Problem while moving.");
        }
    }
}
