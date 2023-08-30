package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JavaRecursion {

    public class FibonacciIterative {
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            int a = 0, b = 1, sum = 0;
            for (int i = 2; i <= n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            return sum;
        }

        public static void main(String[] args) {
            int n = 10; // Calculate the 10th Fibonacci number
            int result = fibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is " + result);
        }
    }

    public class FibonacciRecursive {
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n; // Base case
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
            }
        }

        public static void main(String[] args) {
            int n = 10; // Calculate the 10th Fibonacci number
            int result = fibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is " + result);
        }
    }

    public class FactorialIterative {
        public static int factorial(int n) {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }

        public static void main(String[] args) {
            int n = 5; // Calculate the factorial of 5
            int result = factorial(n);
            System.out.println(n + "! = " + result);
        }
    }

    public class FactorialRecursive {
        public static int factorial(int n) {
            if (n == 0) {
                return 1; // Base case
            } else {
                return n * factorial(n - 1); // Recursive case
            }
        }

        public static void main(String[] args) {
            int n = 5; // Calculate the factorial of 5
            int result = factorial(n);
            System.out.println(n + "! = " + result);
        }
    }


}
