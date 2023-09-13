package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JavaLogicalAndOperator {

    public static void main(String[] args) {
        boolean isVipCustomer = true;
        boolean hasCouponCode = false;

        if (isVipCustomer || hasCouponCode) {
            System.out.println("Congratulations! You qualify for a discount.");
        } else {
            System.out.println("Sorry, no discount available for you.");
        }
    }

    public class DiscountExample {
        boolean isVipCustomer = true;
        boolean hasCouponCode = false;

        if (isVipCustomer || hasCouponCode) {
            System.out.println("Congratulations! You qualify for a discount.");
        } else {
            System.out.println("Sorry, no discount available for you.");
        }
    }

    public class UserInputExample {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Do you have a valid ID? (true/false): ");
        boolean hasValidID = scanner.nextBoolean();

        if (age >= 18 || hasValidID) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
        scanner.close();
    }

    public class PrimeNumberExample {
        int number = 17;
        boolean isDivisible = false;

        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                isDivisible = true;
                break;
            }
        }

        if (!isDivisible || number <= 1) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    public class ShortCircuitEvaluationExample {
        int x = 10;
        int y = 0;

            if (x != 0 || y / x > 2) {
            System.out.println("Condition is true.");
        } else {
            System.out.println("Condition is false.");
        }
    }
}
