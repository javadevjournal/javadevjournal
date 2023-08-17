package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JavaLogicalAndOperator {

    public static void main(String[] args) {
        int age = 18;
        boolean hasID = true;

        if (age >= 18 && hasID) {
            System.out.println("You are eligible to enter the venue.");
        } else {
            System.out.println("Sorry, you cannot enter the venue.");
        }
    }

    public class UserInputValidationExample {
        String username = "john_doe";
        String password = "secure@123";

        boolean isValidUsername = username.length() >= 6 && username.matches("^[a-zA-Z0-9_]+$");
        boolean isValidPassword = password.length() >= 8 && password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]+$");

            if (isValidUsername && isValidPassword) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. Please check username and password requirements.");
        }
    }

    public class LeapYearExample {
        int year = 2024;

        boolean isDivisibleBy4 = year % 4 == 0;
        boolean isDivisibleBy100 = year % 100 == 0;
        boolean isDivisibleBy400 = year % 400 == 0;

            if ((isDivisibleBy4 && !isDivisibleBy100) || isDivisibleBy400) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

    public class ShortCircuitEvaluationExample {
        int x = 5;
        int y = 10;

        if (x > 0 && y / x > 2) {
            System.out.println("Condition is true.");
        } else {
            System.out.println("Condition is false.");
        }
    }
}
