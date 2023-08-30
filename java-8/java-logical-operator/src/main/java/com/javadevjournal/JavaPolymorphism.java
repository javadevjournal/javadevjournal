package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JavaPolymorphism {

    class Shape {
        void draw() {
            System.out.println("Drawing a shape");
        }
    }

    class Circle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a circle");
        }
    }

    class Square extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a square");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Shape shape1 = new Circle();
            Shape shape2 = new Square();

            shape1.draw(); // Output: Drawing a circle
            shape2.draw(); // Output: Drawing a square
        }
    }


    interface Sound {
        void makeSound();
    }

    class Dog implements Sound {
        @Override
        public void makeSound() {
            System.out.println("Dog barks");
        }
    }

    class Cat implements Sound {
        @Override
        public void makeSound() {
            System.out.println("Cat meows");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Sound dog = new Dog();
            Sound cat = new Cat();

            dog.makeSound(); // Output: Dog barks
            cat.makeSound(); // Output: Cat meows
        }
    }

    interface Swimmer {
        void swim();
    }

    interface Flyer {
        void fly();
    }

    class Duck implements Swimmer, Flyer {
        @Override
        public void swim() {
            System.out.println("Duck swims");
        }

        @Override
        public void fly() {
            System.out.println("Duck flies");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Duck duck = new Duck();

            duck.swim(); // Output: Duck swims
            duck.fly();  // Output: Duck flies
        }
    }

    class Vehicle {
        void makeSound() {
            System.out.println("Vehicle makes a sound");
        }
    }

    class Car extends Vehicle {
        @Override
        void makeSound() {
            System.out.println("Car honks");
        }
    }

    class Bike extends Vehicle {
        @Override
        void makeSound() {
            System.out.println("Bike roars");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Vehicle vehicle1 = new Car();
            Vehicle vehicle2 = new Bike();

            vehicle1.makeSound(); // Output: Car honks
            vehicle2.makeSound(); // Output: Bike roars
        }
    }

    class Parent {
        void display() {
            System.out.println("Parent's display method");
        }
    }

    class Child extends Parent {
        @Override
        void display() {
            super.display(); // Calling the parent class's method
            System.out.println("Child's display method");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Child child = new Child();
            child.display();
        }
    }

}
