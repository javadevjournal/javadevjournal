import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaIfElse {
    public static void main(String[] args) {
        int age = 20;
        if (age < 18) {
            System.out.println("You are not an adult.");
        } else {
            System.out.println("You are an adult.");
        }
    }

    public static void ifStatement(String[] args) {
        int age = 30;
        if (age >= 18) {
            System.out.println("You are an adult.");
        }
    }
}
