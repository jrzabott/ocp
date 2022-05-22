package ocp.chapter4;

import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsStudy {
    public static final String METHOD = "\nMethod: ";
    public static final String DASH_LINE = "\n-----------------------";
    private static Logger log = Logger.getLogger(CollectionsStudy.class.getName());

    public static void main(String[] args) {
        log.info("Start");
        collectToList(getOhMy());
        collectToMapAnimalLength(getOhMy());
        collectToMapLenghtAnimalConcatenated(getOhMy());
        collectToMapLengthAnimalConcatenatedTreeMap(getOhMy());
        log.info("End");
    }

    private static void collectToMapLengthAnimalConcatenatedTreeMap(Stream<String> ohMy) {
        final Object collect = ohMy.collect(Collectors.toMap(String::length, animal -> animal, (s1, s2) -> s1 + ";" + s2, TreeMap::new));
        logCollectedStream(collect, METHOD + new Object() {
        }.getClass().getEnclosingMethod().getName() + DASH_LINE);
    }

    private static void logCollectedStream(Object collect, String msg) {
        final String logMsg = msg + "\n" +
                collect.toString() +
                "\n" +
                collect.getClass().toString() +
                "\n";
        log.info(logMsg);
    }

    private static void collectToMapLenghtAnimalConcatenated(Stream<String> ohMy) {
//        final Map<Integer, String> collect = getOhMy().collect(Collectors.toMap(String::length, animal -> animal));// RunTimeException -> Duplicate key and no merge function.
        final Object collect = ohMy.collect(Collectors.toMap(String::length, animal -> animal, (s1, s2) -> s1 + ";" + s2));
        logCollectedStream(collect, METHOD + new Object() {
        }.getClass().getEnclosingMethod().getName() + DASH_LINE);
    }

    private static void collectToMapAnimalLength(Stream<String> ohMy) {
        final Object collect = ohMy.collect(Collectors.toMap(animal -> animal, String::length));
        logCollectedStream(collect, METHOD + new Object() {
        }.getClass().getEnclosingMethod().getName() + DASH_LINE);
    }

    private static void collectToList(Stream<String> ohMy) {
        final Object collect = ohMy.collect(Collectors.toList());
        logCollectedStream(collect, METHOD + new Object() {
        }.getClass().getEnclosingMethod().getName() + DASH_LINE);
    }

    private static Stream<String> getOhMy() {
        return Stream.of("lions", "tigers", "bears");
    }
}
