package ocp.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapApiInJava8 {
    public static void main(String[] args) {

        usingPutInJava8();
        usingMergeInJava8();
        usingComputeIfPresentInJava8();
        usingMapMergeAndComputeMethodsInJava8();

    }

    private static void usingMapMergeAndComputeMethodsInJava8() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 15);
        counts.put("Tom", null);
        System.out.println("Before: " + counts);

        Function<String, Integer> mapper = k -> 1;
        Integer jenny = counts.computeIfAbsent("Jenny", mapper);
        Integer sam = counts.computeIfAbsent("Sam", mapper);
        Integer tom = counts.computeIfAbsent("Tom", mapper);

        System.out.println("After: " + counts);
    }

    private static void usingComputeIfPresentInJava8() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        System.out.println("Before: " + counts);

        BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 10_000;
        Integer jenny = counts.computeIfPresent("Jenny", mapper);
        Integer sam = counts.computeIfPresent("Sam", mapper);

        System.out.println("After: " + counts);
        System.out.println(jenny);
        System.out.println(sam);
    }

    private static void usingMergeInJava8() {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");

        String skyride = "Skyride";
        String jenny = favorites.merge("Jenny", skyride, mapper);
        String tom = favorites.merge("Tom", skyride, mapper);

        System.out.println(favorites);
        System.out.println(jenny);
        System.out.println(tom);

        // notice how merge handles null values
        favorites.put("Sam", null);
        favorites.merge("Sam", skyride, mapper);
        System.out.println(favorites);

        // what happens when mapper returns null?
        BiFunction<String, String, String> mapper2 = (v1, v2) -> null;
        favorites.merge("Sam", skyride, mapper2);
        favorites.merge("John", skyride, mapper2);
        System.out.println(favorites); // John was added, but Sam was removed

    }

    private static void usingPutInJava8() {
        // Using put will replace the value if the key already exists, no matter what.
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Jenny", "Tram");
        System.out.println(favorites);

        // There is the putIfAbsent method, which will only put the key-value pair if the key is not already present.
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites);
    }
}
