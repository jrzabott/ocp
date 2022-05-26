package com.ocp.chapter5;

import java.util.Locale;
import java.util.ResourceBundle;

public class ZooOpen {
    public static void main(String[] args) {
        Locale us = Locale.US;
        Locale france = Locale.FRANCE;
        printProperties(us);
        System.out.println();
        printProperties(france);
    }

    private static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));

        System.out.println();
        System.out.println("Printing all keys as values, using a stream.forEach()");
        rb.keySet().forEach(key -> System.out.println(key + ": " + rb.getString(key)));
    }
}
