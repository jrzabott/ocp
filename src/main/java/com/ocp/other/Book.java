package com.ocp.other;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private Double price;

    private AtomicInteger id = new AtomicInteger(0);

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Book b1 = new Book("A Book", 20.0);
        Book b2 = new Book("Another Book", 30.0);

        Supplier s1 = b1::getPrice;
        Supplier s2 = b2::getPrice;

        System.out.println(b1 + " " + s1.get());


        List<Integer> values = Arrays.asList(2, 4, 6, 9); //1
        Predicate<Integer> check = (Integer i) -> {
            System.out.println("Checking");
            return i == 4; //2
        };

        List<Book> anotherBooks = Arrays.asList(b1, b2, new Book("An another one", 50.0));

        final Map<String, Double> collect = anotherBooks.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice));

    }
}

