import java.util.*;

public class JavaConstructor {
    public static void main(String[] args) {
        javaInstanceOfOperator();
    }

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public class Person {
        private String name;
        private int age;

        public Person() {
            this.name = null;
            this.age = 0;
        }
    }

    public class Person {
        private String name;
        private int age;

        public Person() {
            this.name = "John Doe";
            this.age = 30;
        }
    }

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public class Person {
        private String name;
        private int age;

        public Person() {
            this("John Doe", 30);
        }

        public Person(String name) {
            this(name, 30);
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }



    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(Person other) {
            this.name = other.name;
            this.age = other.age;
        }
    }



}
