package com.ocp.other;


import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Info {
    String s1, s2, s3;

    public Info(){}
    public Info(String a, String b, String c) {
        s1 = a;
        s2 = b;
        s3 = c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Info)) return false;
        Info i = (Info) obj;
        return (s1 + s2 + s3).equals(i.s1 + i.s2 + i.s3);
    }

    public int hashCode() {
        return s1.hashCode();
    }

    public static void main(String[] args) {
        // aExtractedMethod();

//        Father f = new Son();
//        f.vaporize();
//        f.shutdown();

        String[] arr = new String[5];
        for (String s: arr
             ) {
            System.out.println(s);
        }
    }

    private static void aExtractedMethod() {
        HashMap map = new HashMap();
        Info i1 = new Info("aaa", "aaa", "aaa");
        Info i2 = new Info("aaa", "bbb", "ccc");
        Info i3 = new Info("aaa", "aaa", "aaa");
        Info i4 = new Info("aaa", "bbb", "ccc");
        map.put(i1, "hello"); //1
        map.put(i2, "world"); //2
        map.put(i3, "flip"); //2
        map.put(i2, "yeah"); //2

        System.out.println(map
                + "\n"
                + map.get(i1)
                + "\n"
                + map.get(i2)
                + "\n"
                + map.get(i3)
                + "\n"
                + map.get(i4)
        );


        final List<String> strings = Arrays.asList("j", "a", "v", "a");
        final Stream<String> stream = strings.stream();
        System.out.print(stream.collect(Collectors.joining()).toUpperCase());

        File f = new File("/a/b/c/d/e");
        System.out.println(f.getParentFile().toString());

        Outer.Inner oi1 = new Outer().new Inner();
        Outer o1 = new Outer();
        Outer.Inner oi2 = o1.new Inner();
    }

    public class ALocal {}
    public static class BLocal {}
    public void useClasses() {
        new Info().new ALocal();
        new Info.BLocal();
        new ALocal();
        new Info.ALocal();
    }

}

class Outer {
    class Inner {
    }
}


interface GrandPa {
    public void boil();

    public static void shutdown() {
        System.out.println("shutdown");
    }
}

interface Father extends GrandPa {
    public default void vaporize() {
        boil();
        System.out.println("vaporized");
    }
}

class Son implements Father {
    @Override
    public void boil() {
        System.out.println("boiling");
    }
}
