package com.ocp.other;


import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NewClass {
    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }

    public static void main(String[] args) {
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println(grade1.orElse("UNKNOWN"));
        if (grade2.isPresent()) {
            grade2.ifPresent(x -> System.out.println(x));
        } else {
            System.out.println(grade2.orElse("Empty"));
        }

        ReentrantReadWriteLock rl = new ReentrantReadWriteLock();
        rl.readLock().lock();
        rl.readLock().unlock();

        for (int i = 0; i < 100; i++) {
            System.out.println(getAnInt());
        };

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private static int getAnInt() {
        return ThreadLocalRandom.current().nextInt(1, 11);
    }
}