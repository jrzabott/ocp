package ocp.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AdditionsJava8 {
    public static void main(String[] args) {
        // Using method references with static methods
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

        // Using method references with particular instance methods
        String str = "abd";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);

        // Using method references with unkonwn instance methods
        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        // Using method references with constructor
        Supplier<ArrayList<Integer>> methodRef4 = ArrayList::new;
        Supplier<ArrayList<Integer>> lambda4 = () -> new ArrayList<>();
    }
}
