package com.ocp.other;


import java.util.ArrayDeque;
import java.util.Deque;

public class Point {
    int x, y;
    private int myProp;

    void modifyOther(Point p){
        p.myProp = 20;
    }

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        System.out.println(p1);
        p2.modifyOther(p1);
        System.out.println(p1);

        InnerPoint ip = new Point.InnerPoint();
        System.out.println("Inner Point: " + ip);
    }

    @Override
    public String toString() {
        return "Point{" +
                "myProp=" + myProp +
                '}';
    }

    public static class InnerPoint {}
}

class ColoredPoint extends Point {
    int color;
}

class Test {
    static void test(ColoredPoint p, Point q) {
        System.out.println("(ColoredPoint, Point)");
    }

    static void test(Point p, ColoredPoint q) {
        System.out.println("(Point, ColoredPoint)");
    }

    public static void main(String[] args) {
        ColoredPoint cp = new ColoredPoint();
//        test(cp, cp);
        Deque<Integer> d = new ArrayDeque<>();
        d.add(1);
        d.addFirst(2);
        d.pop();
        d.offerFirst(3);
//        System.out.println(d);

        Switch s = Switch.OFF;

        switch (s){
            case ON:
            case OFF:
            default:
                System.out.println(s);
        }
    }
enum Switch {ON, OFF}
}

