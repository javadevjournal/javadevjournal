import java.util.*;

public class JavaThisKeyword {
    public static void main(String[] args) {
        javaInstanceOfOperator();
    }

    public class User {
        private String username;

        public User(String username) {
            setUsername(username);
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public class Person {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public void printName(String localName) {
            System.out.println("Local variable name: " + localName);
            System.out.println("Instance variable name: " + this.name);
        }
    }

    public class UserProfile {
        private String username;
        private int userAge;

        public UserProfile() {
            this("John Doe", 30);
        }

        public UserProfile(String name) {
            this(name, 30);
        }

        public UserProfile(String name, int age) {
            this.username = name;
            this.userAge = age;
        }
    }


}
