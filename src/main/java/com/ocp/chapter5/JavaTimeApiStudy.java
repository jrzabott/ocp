package com.ocp.chapter5;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/*
 * Back to Animalz and Zoo examples.
 * Our zoo tries to bring some fun to the animals. Providing different toy for a peiord of three months.\
 * Switch them at every month.
 */
public class JavaTimeApiStudy {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);

        performAnimalEnrichment(start, end);

        System.out.println("\n");
        System.out.println("Proving an arbitrary period");
        Period twoWeeks = Period.ofWeeks(2);
        performAnimalEnrichment(start, end, twoWeeks);
    }

    /*
     * This method will perform the enrichment for the animals. It does the job but it is not reusable.
     * Luckly, we have Period in Java, we could do the samething in a different way.
     */
    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) { // check if before the end of period.
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1); // add one month to the date.
        }
    }

    /*
     * This method will perform the enrichment for the animals. It does the job but it is reusable.
     * Providing a custom period, we can reuse the code and set an arbitrary interval.
     */
    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) { // check if before the end of period.
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period); // add custom period to the date.
        }
    }
}
