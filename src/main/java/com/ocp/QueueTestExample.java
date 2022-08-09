package com.ocp;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTestExample {
    public static void main(String[] args) {
        Helper h = new Helper();

        Queue<People> people = new LinkedList<People>();
        people.offer(new People("Pope"));
        people.offer(new People("John"));

        Queue<People> helped = new LinkedList<People>();
        h.helpPeople(people, helped);

        System.out.println(helped);
        helped.forEach((Object p) -> System.out.println(p + " Instance of People=" + (p instanceof People) + " Instance of=" + p.getClass().getName()));
    }
}

class Helper{
    public void helpPeople(Queue people, Queue helped){
        do {
            People p = (People) people.poll();
            System.out.println("Helping " + p.getName());
            helped.offer(p.getName());
        } while (!people.isEmpty());
    }
}

class People {
    private String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
