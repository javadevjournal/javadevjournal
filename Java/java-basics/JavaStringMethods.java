import java.util.*;

public class JavaContinue {
    public static void main(String[] args) {
        String str = "Welcome To Javadevjournal!";
        int length = str.length();
        System.out.println("The length of the string is: " + length);
    }

    public static void javaMethods() {
        // Using string literals
        String myString = "Hello, World!";

        // Using the new keyword
        String myString = new String("Hello, World!");

        // Using the valueOf() method
        int myInt = 42;
        String myString = String.valueOf(myInt);

        // Using StringBuilder or StringBuffer
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(", ");
        builder.append("World!");
        String myString = builder.toString();
    }

    public static void charAtExample(String[] args) {
        String str = "Welcome To Javadevjournal!";
        char ch = str.charAt(1);
        System.out.println("The character at index 1 is: " + ch);
    }

    public static void substringExample(String[] args) {
        String str = "Welcome To Javadevjournal!";
        String subStr = str.substring(11, 24);
        System.out.println("The substring is: " + subStr);
    }

    public static void indexOfExample(String[] args) {
        String str = "Welcome to Javadevjournal";
        int index = str.indexOf("o");
        System.out.println("The index of the first 'o' is: " + index);
    }

    public static void replaceMethod(String[] args) {
        String str = "Welcome to Javadevjournal!";
        String newStr = str.replace("o", "0");
        System.out.println("The new string is: " + newStr);
    }
}
