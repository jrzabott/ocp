package com.ocp.chapter4;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalTriangleFactory {
    public static final String LENGTH_MUST_BE_POSITIVE = "Length must be positive";
    private static final Logger logger = Logger.getLogger(PascalTriangleFactory.class.getName());
    private List<List<Integer>> triangle = new ArrayList<>();

    /*
     * Demo for this class.
     */
    public static void main(String[] args) {
        PascalTriangleFactory factory = new PascalTriangleFactory();

        factory.produceTriangle(0);
        factory.getTriangle().ifPresent(PascalTriangleFactory::log);
        factory.produceTriangle(1);
        factory.getTriangle().ifPresent(PascalTriangleFactory::log);
        factory.produceTriangle(2);
        factory.getTriangle().ifPresent(PascalTriangleFactory::log);
        factory.produceTriangle(5);
        factory.getTriangle().ifPresent(PascalTriangleFactory::log);
        factory.produceTriangle(20);
        factory.getTriangle().ifPresent(PascalTriangleFactory::log);
    }

    private static void log(List<List<Integer>> t) {
        t.forEach(l -> logger.info(l.toString()));
    }

    public Optional<List<List<Integer>>> getTriangle() {
        return Optional.ofNullable(triangle);
    }

    void produceTriangle(int length) {
        if (length < 0) throw new IllegalArgumentException(LENGTH_MUST_BE_POSITIVE);

        handleSmallTriangles(length);
        if (length < 3) return;

        this.triangle = initTriangleWithTwoRows();
        int rowCounter = 0;
        while (rowCounter < length) {
            if (++rowCounter > 2) triangle.add(nextRow(triangle.get(rowCounter - 2)));
        }
    }

    /*
     * This method handles smaller triangles, with size 0, 1 and 2.
     */
    private void handleSmallTriangles(int length) {
        switch (length) {
            case 0:
                this.triangle = null;
                break;
            case 1:
                this.triangle = initTriangleWithSingleRow();
                break;
            case 2:
                this.triangle = initTriangleWithTwoRows();
                break;
            default:
        }
    }

    private ArrayList<List<Integer>> initTriangleWithTwoRows() {
        return new ArrayList<>(Arrays.asList(Collections.singletonList(1), Arrays.asList(1, 1)));
    }

    private ArrayList<List<Integer>> initTriangleWithSingleRow() {
        return new ArrayList<>(Collections.singletonList(Collections.singletonList(1)));
    }

    private List<Integer> nextRow(List<Integer> previousLine) {
        List<Integer> result = initList();

        // We only need to parse and evaluate half of the line, the other one is the same, but reversed.
        final int halfOfPreviousLineSize = previousLine.size() / 2;

        // this is a fancy way of doing the following: sum the two numbers in the middle of the previous line, as per Pascal's triangle rule.
        // I needed to work on my functional programming skills, so I used the IntStream.rangeClosed() method to get the indices of the two numbers in the middle of the previous line.
        IntStream.rangeClosed(1, halfOfPreviousLineSize).mapToObj(i -> previousLine.get(i - 1) + previousLine.get(i)).forEach(result::add);

        int lastElementIndex = result.size();
        if (previousLine.size() % 2 == 0) {
            lastElementIndex--;
        }

        // we only need to calculate the first half the list, then append the second half as a mirror (first half reversed)
        final List<Integer> secondHalfOfResult = new ArrayList<>(result.subList(0, lastElementIndex));
        Collections.reverse(secondHalfOfResult);
        // Another fancy way of doing the following: append to the list, the second half of the previous line, as the first half reversed.
        result.addAll(secondHalfOfResult.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        return result;
    }

    /*
     * This is a helper method to initialize the list and add 1 to the beginning.
     */
    private List<Integer> initList() {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        return result;
    }
}
