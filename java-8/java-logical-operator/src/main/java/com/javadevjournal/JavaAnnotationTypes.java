package com.javadevjournal;

import java.lang.annotation.*;
import org.junit.*;

public class JavaAnnotationTypes {

    @SuppressWarnings("unchecked")
    List<String> myList = new ArrayList();

    class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Dog barks");
        }
    }

    class OldClass {
        @Deprecated
        void oldMethod() {
            // Deprecated method implementation
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface MyAnnotation {
        String value() default "default value";
        int count() default 1;
    }

    @MyAnnotation(value = "custom value", count = 5)
    public void myMethod() {
        // Method implementation
    }

    public class Main {
        public static void main(String[] args) throws NoSuchMethodException {
            Method method = Main.class.getMethod("myMethod");
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Value: " + annotation.value());
            System.out.println("Count: " + annotation.count());
        }

        @MyAnnotation(value = "custom value", count = 5)
        public void myMethod() {
            // Method implementation
        }
    }

    public class MyUnitTest {
        @Before
        public void setup() {
            // Setup code
        }

        @Test
        public void testSomething() {
            // Test code
        }

        @Test
        public void testAnotherThing() {
            // Test code
        }
    }


}
