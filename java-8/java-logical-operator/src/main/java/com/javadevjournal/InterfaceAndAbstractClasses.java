package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class InterfaceAndAbstractClasses {

    interface Shape {
        double area();
        double perimeter();
    }

    class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    abstract class Animal {
        abstract void speak();
        void eat() {
            System.out.println("Eating...");
        }
    }

    abstract class Animal {
        abstract void speak();
        void eat() {
            System.out.println("Eating...");
        }
    }

    class Dog extends Animal {
        @Override
        void speak() {
            System.out.println("Woof!");
        }
    }

    class Cat extends Animal {
        @Override
        void speak() {
            System.out.println("Meow!");
        }
    }

    abstract class Vehicle {
        void startEngine() {
            System.out.println("Engine started.");
        }

        abstract void stopEngine();
    }

    interface ElectricVehicle {
        void chargeBattery();
    }

    class ElectricCar extends Vehicle implements ElectricVehicle {
        @Override
        void stopEngine() {
            System.out.println("Engine stopped.");
        }

        @Override
        public void chargeBattery() {
            System.out.println("Battery charging...");
        }
    }
}
