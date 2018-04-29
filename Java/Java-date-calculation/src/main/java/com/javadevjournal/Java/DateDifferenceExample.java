package com.javadevjournal.Java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDifferenceExample {

    public void calculate_difference_between_dates() throws ParseException {
        String currentDate=  "10/24/2017";
        String finalDate=  "10/28/2017";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = simpleDateFormat.parse("06/24/2017");
        Date secondDate = simpleDateFormat.parse("06/30/2017");

        long difference = Math.abs(firstDate.getTime() - secondDate.getTime());
        long differenceDates = difference / (24 * 60 * 60 * 1000);

        //Convert long to String
        String dayDifference = Long.toString(differenceDates);
        System.out.println("Day Differnec is " + dayDifference);
    }
}
