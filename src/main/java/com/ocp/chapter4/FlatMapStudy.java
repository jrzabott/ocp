package com.ocp.chapter4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapStudy {

    private static List<Integer> list1 = Arrays.asList(1, 2, 3);
    private static List<Integer> list2 = Arrays.asList(4, 5, 6, 7);
    private static List<List<Integer>> list3 = Arrays.asList(Arrays.asList(11, 12, 13, 14));
    private static List<List<Integer>> list4 = Arrays.asList(Arrays.asList(15, 16, 17, 18, 19));
    private static List<List<Integer>> listOfLists = Arrays.asList(list1, list2);
    private static List<List<List<Integer>>> listOfLists2 = Arrays.asList(list3, list4);

    private static Stream<String> getStringStream() {
        return Stream.of("lorem", "ipsum", "dolor", "sit", "amet");
    }

    public static void main(String[] args) {
        flatMapExample1();
        convertingWordsToListOfCharAndPrintingThem();
        convertListOfWordsToListOfChartsUsingFlatMap();
        fabricateAndGetPascalTriangle().ifPresent(list -> list.forEach(System.out::println));
    }

    private static Optional<List<List<Integer>>> fabricateAndGetPascalTriangle() {
        final PascalTriangleFactory factory = new PascalTriangleFactory();
        factory.produceTriangle(10);
        final Optional<List<List<Integer>>> triangle = factory.getTriangle();
        return triangle;
    }

    private static void convertListOfWordsToListOfChartsUsingFlatMap() {
        Stream<String> stringStream = getStringStream();
        final List<Character> collect = stringStream.map(CharSequence::chars)
                .flatMap(chars -> chars.mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void convertingWordsToListOfCharAndPrintingThem() {
        // lets generate a list of characters for all the words.
        Stream<String> stringStream = getStringStream();
        Function<String, IntStream> intStreamFunction = CharSequence::chars;
        Function<IntStream, Stream<Character>> intStreamToStreamFunction = i -> i.mapToObj(c -> (char) c);
        stringStream
                .map(intStreamFunction // invoke 1st function: converts every word into a IntStream by the Character.chars() method.
                        .andThen(intStreamToStreamFunction)) // chaining function: invoke the 2nd function: converts the IntStream into a Stream<Character> by the mapToObj method.
                .forEach(s -> System.out.println(s.collect(Collectors.toList()))); // for each object Stream<Character> (which represents exploded word), collect it as a List<Character> and then prints it.
    }

    private static void flatMapExample1() {

        // simple list (and list of lists) flattening
        final List<Integer> collect = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(listOfLists2);
        final List<List<Integer>> collect1 = listOfLists2.stream().flatMap(Collection::stream).collect(Collectors.toList());
        final List<Integer> collect2 = listOfLists2.stream().flatMap(Collection::stream).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(collect2);
    }
}
