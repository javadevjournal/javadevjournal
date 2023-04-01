import java.util.*;

public class JavaThisKeyword {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return super.add(a, b) + c;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int result1 = calc.add(2, 3);
        double result2 = calc.add(2.5, 3.5);

        System.out.println(result1);
        System.out.println(result2);
    }
}
