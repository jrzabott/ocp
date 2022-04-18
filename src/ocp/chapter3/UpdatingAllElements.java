package ocp.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UpdatingAllElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        UnaryOperator<Integer> doubleIt = x -> x * 2;
        list.replaceAll(doubleIt);
        System.out.println(list);
    }
}
