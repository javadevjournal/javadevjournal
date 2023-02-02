import java.util.*;

public class JavaForEachLoop {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i+1;
        }
        System.out.println("The sum of numbers from 1 to 10 is: " + sum);
    }

    public static void forLoop(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }


}
