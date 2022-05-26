package com.ocp.chapter5;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatters {

    public static void main(String[] args) {
        formattingInteger();
        formattinCurrency();
        formattingDatesAndTimes();
    }

    private static void formattingDatesAndTimes() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY,20);
        LocalTime time = LocalTime.of(11,12,34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter formatterShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(formatterShort.format(date));
//        System.out.println(formatterShort.format(time)); // throws exception, why? because LocalTime does not contain a date, or date fields.
        System.out.println(formatterShort.format(dateTime));

        DateTimeFormatter formatterMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(formatterMedium.format(date));
//        System.out.println(formatterShort.format(time)); // throws exception, why? because LocalTime does not contain a date, or date fields.
        System.out.println(formatterMedium.format(dateTime));

        // Finally, formatting from a pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(dateTime));
    }

    private static void formattinCurrency() {
        final double ticketPrice = 48;
        NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat deCurrency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        NumberFormat frCurrency = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println(usCurrency.format(ticketPrice));
        System.out.println(deCurrency.format(ticketPrice));
        System.out.println(frCurrency.format(ticketPrice));
    }

    private static void formattingInteger() {
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        NumberFormat de = NumberFormat.getInstance(Locale.GERMANY);
        NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);

        final int attendeesPerYear = 3_200_000;
        final int attendeesPerMonth = attendeesPerYear / 12;

        System.out.println(us.format(attendeesPerMonth));
        System.out.println(de.format(attendeesPerMonth));
        System.out.println(fr.format(attendeesPerMonth));
    }
}
