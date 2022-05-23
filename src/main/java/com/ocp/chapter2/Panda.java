package com.ocp.chapter2;

import java.util.function.Predicate;

public class Panda {
    int age;
    public static void mTain(String[] args) {
        Panda p1 = new Panda();
        p1.age = 1;
        check(p1, p -> p.age < 5);
    }

    private static void check(Panda p, Predicate<Panda> pred){
        String result = pred.test(p) ? "match" : "not match";
        System.out.println(result);
    }
}
