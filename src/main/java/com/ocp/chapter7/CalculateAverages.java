package com.ocp.chapter7;

public class CalculateAverages implements Runnable {
    private double[] scores;

    public CalculateAverages(double[] scores) {
        this.scores = scores;
    }

    @Override
    public void run() {
        double sum = 0.0;
        for (double n : scores){
            sum += n;
        }
        System.out.printf("Average: %s%n", sum / scores.length);
    }
}
