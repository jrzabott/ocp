package com.ocp.chapter7;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class WeighAnimalAction extends RecursiveAction {

    public static final int TASK_MAX_CAPACITY = 3;
    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalAction(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<?> task = new WeighAnimalAction(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        // print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.stream(weights).forEach(w -> System.out.printf("%.0f ", w));
    }

    @Override
    protected void compute() {
        if (end - start <= TASK_MAX_CAPACITY) { // each task/worker can collect up to 3 weights
            final SecureRandom random;
            try {
                random = SecureRandom.getInstance("SHA1PRNG");
                for (int i = start; i < end; i++) {
                    weights[i] = random.nextDouble() * 100.0;
                    System.out.println("Weighing animal " + i + ": " + weights[i]);
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            int middle = start + ((end - start) / 2);
            System.out.println("start: " + start + " end: " + end + " middle: " + middle);
            invokeAll(new WeighAnimalAction(start, middle, weights), new WeighAnimalAction(middle, end, weights));
        }
    }
}
