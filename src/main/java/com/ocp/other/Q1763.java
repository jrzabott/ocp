package com.ocp.other;


import java.io.Console;
import java.util.ResourceBundle;

abstract class Switch {
    protected abstract void switchON();

    protected abstract void switchOFF();
}

class SimpleSwitch extends Switch {
    public final void switchON() {
        System.out.println("Switched ON");
    }

    public final void switchOFF() {
        System.out.println("Switched OFF");
    }
}

class Fan {
    Switch sw = new SimpleSwitch();

    public void test() {
        sw.switchON();
        sw.switchOFF();
    }
}

public class Q1763 {
    public static void main(String[] args) {
        Fan f = new Fan();
        f.test();

Thread t;
Console c;
        ResourceBundle rb = ResourceBundle.getBundle("");
    }
}
