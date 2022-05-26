package com.ocp.chapter5;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ZooOpen {
    public static void main(String[] args) {
        Locale us = Locale.US;
        Locale france = Locale.FRANCE;
        printProperties(us);
        System.out.println();
        printProperties(france);

        Properties props = loadBundleToPropertiesAndPrintIt();

        printingANonExistentProperty(props);
    }

    private static void printingANonExistentProperty(Properties props) {
        System.out.println();
        System.out.println("Trying to print an nonexistent prop, and print a default value");
        final String property = props.getProperty("nonExistent", "default value");
        System.out.println("Non existent property <" + property + ">");
    }

    private static Properties loadBundleToPropertiesAndPrintIt() {
        Properties props = loadResourceBundleToProperties();
        System.out.println();
        System.out.println("Printing all props, using a stream.forEach()");
        props.forEach((key, value) -> System.out.println(key + ": " + value));
        return props;
    }

    private static Properties loadResourceBundleToProperties() {
        Properties props = new Properties();
        ResourceBundle rb = ResourceBundle.getBundle("Zoo");
        rb.keySet().forEach(key -> props.put(key, rb.getString(key)));
        return props;
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
