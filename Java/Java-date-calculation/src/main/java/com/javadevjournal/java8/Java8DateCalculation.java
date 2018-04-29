package com.javadevjournal.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Java8DateCalculation {

    public void calculate_difference_between_dates(){

        //Use LocalDate and ChronoUnit
        LocalDate firstDate = LocalDate.of(2017, 5, 6);
        LocalDate currentDate = LocalDate.now();

        long days = ChronoUnit.DAYS.between(firstDate, currentDate);
        System.out.println(days);

        //date calculation
        LocalDate now = LocalDate.now();
        LocalDate tenDaysAhead = now.plusDays(10);
        System.out.println(tenDaysAhead.toString());
    }
}
