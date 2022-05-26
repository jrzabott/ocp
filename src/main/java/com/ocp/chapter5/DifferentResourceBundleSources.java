package com.ocp.chapter5;

import java.util.Locale;
import java.util.ResourceBundle;

public class DifferentResourceBundleSources {
    public static void main(String[] args) {
        printStringsAccordingToHierarchy();
    }

    private static void printStringsAccordingToHierarchy() {
        Locale l = new Locale("en", "CA");
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", l);
        System.out.println(rb.getString("hello"));
        System.out.println();
        System.out.println(rb.getString("name"));
        System.out.println();
        System.out.println(rb.getString("open"));
        System.out.println();
        System.out.println(rb.getString("visitor"));
        System.out.println();
        System.out.println(rb.getString("closed"));
        System.out.println();
    }
}
