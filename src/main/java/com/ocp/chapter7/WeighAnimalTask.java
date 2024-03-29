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
        Double[] weights = new Double[10];

        ForkJoinTask<Double> task = new WeighAnimalTask(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);

        // print results
        System.out.println();
        System.out.print("Weights: ");
        System.out.println(Arrays.toString(weights));
        System.out.println("Manual sum: " + Arrays.stream(weights).mapToDouble(w -> w).sum());

        // print only the sum of the weights
        System.out.println();
        System.out.println("Sum of weights: " + sum);
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
            weights[i] = weights.length == 10 ? generateRandomWeight(i) : generateRandomWeight();
            System.out.println("Animal Weighted: " + i + ": " + weights[i]);
            sum += weights[i];
        }
        return sum;
    }

    private double generateRandomWeight(int i) {
        double[] localWeight = {94, 73, 8, 92, 75, 63, 76, 60, 73, 3};
        return localWeight[i];
    }

    private double generateRandomWeight() {
        double result = 0.0;
        try {
            while (result <= 0.0) {
                result = SecureRandom.getInstance("SHA1PRNG").nextInt(100);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error generating random weight: " + e.getMessage());
        }
        return result;
    }
}
