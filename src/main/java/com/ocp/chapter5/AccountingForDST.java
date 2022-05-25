package com.ocp.chapter5;

import java.time.*;

public class AccountingForDST {

    public static final String US_EASTERN = "US/Eastern";

    public static void main(String[] args) {
        advancingOneHourInDSTHourChangeAndAlsoOffSet();
        advancingOneHourAtTheTimeAfterDSTChangedBack();
        tryingToCreateAnNonexistentTime();


    }

    private static void tryingToCreateAnNonexistentTime() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(2, 30);
        ZoneId zone = ZoneId.of(US_EASTERN);
        ZonedDateTime zdt = ZonedDateTime.of(date, time, zone);
        System.out.println();
        System.out.println(zdt);
    }

    private static void advancingOneHourAtTheTimeAfterDSTChangedBack() {
        LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 06);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of(US_EASTERN);
        ZonedDateTime zdt = ZonedDateTime.of(date, time, zone);

        System.out.println();
        System.out.println(zdt);
        zdt = zdt.plusHours(1);
        System.out.println(zdt);
        zdt = zdt.plusHours(1);
        System.out.println(zdt);
    }

    private static void advancingOneHourInDSTHourChangeAndAlsoOffSet() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of(US_EASTERN);
        ZonedDateTime zdt = ZonedDateTime.of(date, time, zone);
        System.out.println();
        System.out.println(zdt);
        zdt = zdt.plusHours(1);
        System.out.println(zdt);
    }
}
