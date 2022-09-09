package com.ocp.other;

import java.util.*;
import java.util.stream.Stream;

abstract class Saloon {
    protected int m1(){
        return 0;
    }
}

public class OverridingSaloon extends Saloon{
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("a", "b");
        List<String> l2 = Arrays.asList("0", "1");

        Stream.of(l1, l2).flatMap(x -> x.stream()).forEach(System.out::println);

        Outter o = new Outter();
        Outter.Inner i = o.new Inner();

        Map<Object, Object> map = new HashMap<>();

        map.put("1", new Object());
        map.put(1, new ArrayList());
        map.put(2.0, "Hello");

        map.forEach((k, v) -> System.out.println(k + ": " + v));


    }
}

class Outter{
    class Inner{}
}