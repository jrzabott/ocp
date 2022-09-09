package com.ocp.other;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AelafTest {

    static int a, b, c;

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();

        final int x = 23;
        final double x1 = 2.0;
        final long x2 = 10L;

        m2(list, x);
        m2(list, x1);
        m2(list, x2);

        System.out.println(list);

        System.out.println(m1(list, 2));

        System.out.println(LocalTime.now().until(LocalTime.of(10, 45), ChronoUnit.HOURS));

        Path p = Paths.get("\\temp\\records");
        p = p.resolve("clients.dat");
        System.out.println(p.toString() + "   " +
                p.startsWith("temp") + "  " +
                p.endsWith("clients.dat") + "   " +
                (p.startsWith("temp") && p.endsWith("clients.dat"))
        );

        List<String> strings = Arrays.asList("aa", "aaa", "b", "cc", "ccc", "ddd", "a");
        final Stream<String> stream = strings.stream();
        final long count = stream.filter(s -> s.compareTo("count") < 0).count();
        System.out.println(count);

        test(a, oops(2), c);
        System.out.println(a + " " + b + " " + c);

        myAbstract myAbstract = new myAbstract() {
            @Override
            void m1() {
                System.out.println("oh yeah!");
            }
        };

        Map<?, List<String>> aMap= new HashMap<String, List<String>>();
    }

    static Number m1(List<? extends Number> list, Integer i) {
        return list.get(i);
    }

    static void m2(List<? super Number> list, Number x) {
        list.add(x);
    }

    static int test(int a, int b, int c) {
        return a + b + c;
    }

    static int oops(int a) {
        new Exception("Ooops");
        return 0;
    }

    abstract static class myAbstract{
        abstract void m1();
    }


}
class Fruit extends Food implements Eatable {
    public static void main(String[] args) {
//        types = 30;
//        System.out.println(types);

        double principle = 100;
        int interestrate = 5;
        double amount1 = compute1(principle, x -> x * interestrate);
        double amount2 = compute2(principle, x -> x * interestrate);

        System.out.println(amount1);
        System.out.println(amount2);

        class C{};

        List<Integer> iList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Predicate<Integer> predicate = x -> x%2 == 0;

        List aList = iList.stream().filter(predicate).filter(x-> x> 3).collect(Collectors.toList());
        System.out.println(aList);
    }

    private static double compute1(double principle, Function<Double, Double> function) {
        return function.apply(principle);
    }
    private static double compute2(double principle, Function<Integer, Integer> function) {
        return function.apply((int)principle);
    }
}
interface Eatable {

    int types = 10;
}
class Food implements Eatable {

    public static int types = 20;
}


