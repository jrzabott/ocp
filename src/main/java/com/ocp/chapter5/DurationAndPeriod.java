package com.ocp.chapter5;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DurationAndPeriod {
    public static void main(String[] args) {
        printSomePeriods();
        printSomeDurations();
        cannotApplyPeriodToTimeOnlyObjects();
        cannotApplyDurationToDateOnlyObjects();
    }

    private static void cannotApplyDurationToDateOnlyObjects() {
        LocalDate date = LocalDate.of(2019, 1, 1);
        LocalTime time = LocalTime.of(8, 22);
        LocalDateTime dateTime= LocalDateTime.of(date, time);

        Duration duration = Duration.ofHours(1);

        System.out.println("Cannot apply duration to date objects");


        try {
            System.out.println("Time before: " + time);
            time = time.plus(duration);
            System.out.println("Time after: " + time);
            System.out.println();

            System.out.println("DateTime before: " + time);
            dateTime = dateTime.plus(duration);
            System.out.println("DateTime after: " + dateTime);
            System.out.println();

            System.out.println("Date before: " + date);
            date = date.plus(duration);
            System.out.println("Date after: " + date);
            System.out.println();
        } catch (Exception e) {
            System.out.println("EXCEPTION: Cannot apply Duration to Date objects.\n" + e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    private static void cannotApplyPeriodToTimeOnlyObjects() {
        // Period cannot be applied to time objects
        LocalDate date = LocalDate.of(2019, 1, 1);
        LocalTime time = LocalTime.of(8, 22);
        LocalDateTime dateTime= LocalDateTime.of(date, time);

        Period period = Period.ofDays(1);

        System.out.println("Cannot apply period to time objects");


        try {
            System.out.println("Date before: " + date);
            date = date.plus(period);
            System.out.println("Date after: " + date);
            System.out.println();

            System.out.println("DateTime before: " + time);
            dateTime = dateTime.plus(period);
            System.out.println("DateTime after: " + dateTime);
            System.out.println();

            System.out.println("Time before: " + time);
            time = time.plus(period);
            System.out.println("Time after: " + time);
            System.out.println();
        } catch (Exception e) {
            System.out.println("EXCEPTION: Cannot apply period to time objects.\n" + e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    private static void printSomeDurations() {
        Duration daily = Duration.ofDays(1);
        Duration hour = Duration.ofHours(1);
        Duration minute = Duration.ofMinutes(1);
        Duration second = Duration.ofSeconds(1);
        Duration milli = Duration.ofMillis(1);
        Duration nano = Duration.ofNanos(1);
        Duration custom = Duration.of(33, ChronoUnit.HOURS);

        System.out.println("Some durations");
        Arrays.asList(daily, hour, minute, second, milli, nano, custom).forEach(System.out::println);
        System.out.println();
    }

    private static void printSomePeriods() {
        Period annually = Period.ofYears(1);
        Period quarterly = Period.ofMonths(3);
        Period monthly = Period.ofMonths(1);
        Period weekly = Period.ofWeeks(1);
        Period daily = Period.ofDays(1);
        Period aYearAndAWeek = Period.of(1, 0, 7);

        System.out.println("Some periods");
        Arrays.asList(annually, quarterly, monthly, weekly, daily, aYearAndAWeek).forEach(System.out::println);
        System.out.println();
    }
}
