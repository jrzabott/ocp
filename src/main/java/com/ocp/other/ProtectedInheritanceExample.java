package com.ocp.other;

import com.ocp.other.p1.A;
import com.ocp.other.p2.B;

public class ProtectedInheritanceExample {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        b.process(a);
        System.out.println(a.getI());
    }
}



