import java.util.*;

public class JavaContinue {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = new String("Hello, World!");
    }

    public static void stringPool() {
        String str1 = "Hello, World!";
        String str2 = "Hello, World!";
    }

    public static void accessingStringData(String[] args) {
        String str = "Hello, World!";
        char firstChar = str.charAt(0);
    }

    public static void manipulateString(String[] args) {
        String str1 = "Hello, ";
        String str2 = "World!";
        String result = str1 + str2;

        String str = "Hello, World!";
        String upperCaseStr = str.toUpperCase();
        String lowerCaseStr = str.toLowerCase();
    }
}
