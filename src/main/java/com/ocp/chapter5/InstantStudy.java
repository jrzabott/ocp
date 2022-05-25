package com.ocp.chapter5;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class InstantStudy {
    public static void main(String[] args) throws InterruptedException {
        LocalDate date = LocalDate.of(2015, Month.MAY, 25);
        LocalTime time = LocalTime.of(11,55);
        LocalDateTime localDateTIme = LocalDateTime.of(date, time);
        final ZoneId zone = ZoneId.of("US/Eastern");
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTIme, zone);
        final long epochSecond = zonedDateTime.toEpochSecond();
        final Instant instant = Instant.ofEpochSecond(epochSecond);
        System.out.println("localDateTime: " + localDateTIme);
        System.out.println("zonedDateTime" + zonedDateTime);
        System.out.println("instant: " + instant);


        try {
            Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
            System.out.println("nextDay: " + nextDay);
            Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
            System.out.println("nextHour: " + nextHour);
            Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS);
            System.out.println("nextWeek: " + nextWeek);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


//        convertingAZonedDateTimeToInstant();
//        countLongTimeOperation();
    }

    private static void convertingAZonedDateTimeToInstant() {
        LocalDate date = LocalDate.of(2015, Month.MAY, 25);
        LocalTime time = LocalTime.of(11,55);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
        final Instant instant = zonedDateTime.toInstant();
        System.out.println(zonedDateTime);
        System.out.println(instant);
    }

    private static void countLongTimeOperation() throws InterruptedException {
        Instant t0 = Instant.now();
        Thread.sleep(3000);
        Instant t1 = Instant.now();

        Duration duration = Duration.between(t0, t1);
        System.out.println("Time passed: " + duration.toMillis());
    }
}
