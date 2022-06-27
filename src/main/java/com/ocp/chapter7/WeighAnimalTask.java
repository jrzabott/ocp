package com.ocp.chapter7;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class WeighAnimalTask extends RecursiveTask<Double> {

    public static final int TASK_MAX_CAPACITY = 3;
    private final int start;
    private final int end;
    private final Double[] weights;

    public WeighAnimalTask(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    public static void main(String[] args) {
        Double[] weights = new Double[20];

        ForkJoinTask<?> task = new WeighAnimalAction(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        // print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.stream(weights).forEach(w -> System.out.printf("%.0f ", w));
    }

    @Override
    protected Double compute() {
        if (end - start <= 3) return weightFewAnimals();
        else return weightLotsOfAnimals();

    }

    private Double weightLotsOfAnimals() {
        int middle = start + ((end - start) / 2);
        System.out.println("[start: " + start + " end: " + end + " middle: " + middle + "]");
        RecursiveTask<Double> otherTask = new WeighAnimalTask(start, middle, weights);
        otherTask.fork();
        return new WeighAnimalTask(middle, end, weights).compute() + otherTask.join();
    }

    private double weightFewAnimals() {
        double sum = 0;
        for (int i = start; i < end; i++) {
            weights[i] = generateRandomWeight();
            System.out.println("Animal Weighted: " + i + ": " + weights[i]);
            sum += weights[i];
        }
        return sum;
    }

    private double generateRandomWeight() {
        double result = 0.0;
        try {
            result = SecureRandom.getInstance("SHA1PRNG").nextInt() * 100.0;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error generating random weight: " + e.getMessage());
        }
        return result;
    }
}
