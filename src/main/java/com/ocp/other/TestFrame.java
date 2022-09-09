package com.ocp.other;

import com.ocp.other.Point.InnerPoint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.DoubleStream;

public class TestFrame extends Frame {
    String s = "Message";

    public static void main(String args[]) {
        TestFrame t = new TestFrame();
        Button b = new Button("press me");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Message is " + s);
            }
        });
        t.add(b);

        DoubleStream ds = DoubleStream.of(0, 2, 4);
        double sum = ds.filter(x -> x % 2 == 0).sum();
        System.out.println(sum);
        InnerPoint ip = new InnerPoint();

        AnInterface ai = new AnInterface() {
        };

    }

    private class C{}
}

interface AnInterface {
}

interface AnotherInterface {
}