package com.ocp.other;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        Office off = new HomeOffice();
        // System.out.println(off.getAddress());

        for (Card value : Card.values()) {

        }

    }
}


interface Home {
    public default String getAddress() {
        return "house address";
    }
}

interface Office {
    public static String getAddress() {
        return "office address";
    }
}

interface wfh extends Home, Office {
}

class HomeOffice implements Home, Office {
    public String getAddress() {
        return "home office address";
    }
}


enum Card {
    HEART, CLUB, SPADE, DIAMOND
}


class Names {

    private int i;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void printNames() {
        System.out.println(getList());
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Bob Hope", "Bob Dole", "Bob Brown");
        Names n = new Names();
        n.setList(list.stream().collect(Collectors.toList()));
        // n.getList().forEach(Names::printNames);

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);

        Predicate<Integer> p1 = k -> k < 10;
        long count1 = primes.stream().filter(p1).count();

        Predicate<Integer> p2 = k -> k > 10;
        long count2 = primes.stream().filter(p2).count();

        System.out.println(count1 + " " + count2);

        Path path = Paths.get   ("/a/b/c");
        String x = path.getName(1).toString();
        String y = path.subpath(1, 2).toString();
        System.out.println(x + " : " + y);

        Connection con;
        Statement stmt;

    }

    class Inner {
        public void metA() {
            System.out.println(Names.this.i);
        }
    }


}


enum EnumA {A, AA, AAA};  //1

class A {

    A() {
    }

    A(String s) {
        this();
        System.out.println(s);
    }
}

class B extends A {
    public int B(String s) {
        System.out.println("B:" + s);
        return 0;
    }
}

class C extends B {
    C() {
        super();
    }

    C(String s) {
        this();
        System.out.println("C: " + s);
    }

    C(int i) {
    }
}