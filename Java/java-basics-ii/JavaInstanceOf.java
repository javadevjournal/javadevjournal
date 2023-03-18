import java.util.*;

public class JavaFinal {
    public static void main(String[] args) {
        javaInstanceOfOperator();
    }

    public static void javaInstanceOfOperator() {
        String str = "Hello, World!";
        boolean result = str instanceof String;
        System.out.println(result);
    }

    class Animal {}
    class Dog extends Animal {}

    public void checkInstance() {
        Animal animal = new Dog();
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            System.out.println("Woof!");
        }
    }

    public void javaInstanceOfInterface() {
        Thread thread = new Thread();
        if (thread instanceof Runnable) {
            System.out.println("Thread implements Runnable");
        }
    }

    public void typeCastingWithInstanceOf() {
        Object animal = new Cat();
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.bark();
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.meow();
        }
    }
}
