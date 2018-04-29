package com.javadevjournal;

import com.javadevjournal.Java.DateDifferenceExample;
import com.javadevjournal.java8.Java8DateCalculation;

import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {
        Java8DateCalculation dateDifferenceExample = new Java8DateCalculation();
        dateDifferenceExample.calculate_difference_between_dates();
    }
}
