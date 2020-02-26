import java.util.Arrays;
import java.util.List;
public class ExampleAccumulator {
   public static void main(String[] args) {
       List<Integer> givenNumbers = Arrays.asList(2, 4, 6, 8, 10);
       int average = givenNumbers.stream().reduce((total, currentValue) -> total + currentValue).orElse(0) / givenNumbers.size();
       System.out.print("Average : " + average);
   }
}