package com.ocp.chapter3;

import java.util.ArrayList;
import java.util.List;

public class RemovingConditionally {
    public static void main(String[] args) {
        // Using method removeIf
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list); // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]
    }
}
