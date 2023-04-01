import java.util.*;

public class JavaAccessModifiers {
    public static void main(String[] args) {
        javaInstanceOfOperator();
        printHello();

        int sum = add(2, 3);

        boolean result = isPositive(-5);
    }

    public void printHello() {
        System.out.println("Hello");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isPositive(int num) {
        return num > 0;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isPositive(int num) {
        return num > 0;
    }




}
