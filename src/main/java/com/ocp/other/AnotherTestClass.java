package com.ocp.other;

import java.util.*;
import java.util.concurrent.Callable;


class AnotherBook {
    private String title, isbn;

    public boolean equals(Object o) {
        return (o instanceof AnotherBook && ((AnotherBook) o).isbn.equals(this.isbn));
    }      // ... setters and getters for title and isbn

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

class BookStore {
    Map<AnotherBook, Integer> map = new HashMap<AnotherBook, Integer>();

    int getNumberOfCopies(AnotherBook b) {
        return map.get(b);
    }

    public void addBook(AnotherBook b, int numberofcopies) {
        map.put(b, numberofcopies);
    }     // ... other useful methods.
}

public class AnotherTestClass {
    static BookStore bs = new BookStore();

    public static void main(String[] args) {
//        AnotherBook b = new AnotherBook();
//        b.setIsbn("111");
//        bs.addBook(b, 10);
//        System.out.println(bs.getNumberOfCopies(b));
//        b = new AnotherBook();
//        b.setIsbn("111");
//        System.out.println(bs.getNumberOfCopies(b));
//
//        ACallableClass a = new ACallableClass();
//
//        Stream<String> stream = Stream.of("");
//
//        final PrintWriter pw = new PrintWriter(System.out);
//        final boolean b1 = true;
//        pw.print(b1);
//
//        ReentrantLock rl = new ReentrantLock();

        List<? extends Number> numExtList = new ArrayList<>();
        List<? super Number> numSuperList = new ArrayList<>();

        final Object anObject = new Object();
        final Number aNumber = new Integer(11);
        final Integer anInteger = new Integer(10);

//        numExtList.add(anObject);
//        numExtList.add(aNumber);
//        numExtList.add(anInteger);

//        numSuperList.add(anObject);
        numSuperList.add(aNumber);
        numSuperList.add(anInteger);

        List<? extends InterfA> aEList = new ArrayList<>();
        List<? super InterfA> aSList = new ArrayList<>();

        final InterfA anInterfA = new InterfA() {};
        final InterfB anInterfB = new InterfB() {};

//        aEList.add(anObject);
//        aEList.add(anInterfA);
//        aEList.add(anInterfB);
//
//        aSList.add(anObject);
        aSList.add(anInterfA);
        aSList.add(anInterfB);

        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        final int sum = integers.stream()
                .mapToInt(x -> x)
                .sum();
        System.out.println(sum);
        System.out.println(integers.stream().reduce((a, b) -> a + b));

        final List<Double> doubles = Arrays.asList(10.0, 12.0);
        doubles.stream().forEach(x -> x = x * 2.0);
        doubles.stream().forEach(System.out::println);

    }
}

interface InterfA{}
interface InterfB extends InterfA {}


class ACallableClass implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "null";
    }
}

