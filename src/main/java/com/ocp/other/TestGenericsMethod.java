package com.ocp.other;

import java.util.*;

class MyShape{};
class Square extends  MyShape{}
class Circle extends  MyShape{}

public class TestGenericsMethod {
//     List<MyShape> m3(ArrayList<? extends MyShape> strList){
//         List<? extends MyShape> list = new ArrayList<>();
//         list.addAll(strList)
//        return list;
//    }

     List<? extends MyShape> m4(List<? extends MyShape> strList){
         List<MyShape> list = new ArrayList<>();
         list.add(new MyShape());
         list.addAll(strList);
        return list;
    }

     void m5(ArrayList<? extends MyShape> strList){
         List<MyShape> list = new ArrayList<>();
         list.add(new MyShape());
         list.addAll(strList);
    }

//     void m6(ArrayList<MyShape> strList){
//         List<? extends MyShape> list = new ArrayList<>();
//         list.add(new MyShape());
//         list.addAll(strList);
//    }

    public static void main(String[] args) {
        //extracted();

        Set<APersonDaniel> set = new TreeSet<>();
        set.add(new APersonDaniel("Banana"));

        System.out.println(set);
    }

    private static void extracted() {
        Map m = new HashMap<>();
        Map<String, List<String>> m2 = new HashMap();

        m2.put("A", new ArrayList<>());

        List<String> l1 = new ArrayList<>();
        l1.add("A");
        List<? extends String> l2 = new ArrayList<>();
        l1.addAll(l2);

        l1.addAll(new ArrayList<>());

        System.out.println(m2);
        System.out.println(l1);
        System.out.println(l2);

    }

}

class APersonDaniel {
    String name = "";

    public APersonDaniel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "APersonDaniel{" +
                "name='" + name + '\'' +
                '}';
    }
}