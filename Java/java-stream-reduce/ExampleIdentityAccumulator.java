import java.util.Arrays;
import java.util.List;
public class ExampleIdentityAccumulator {
   public static void main(String[] args) {
       List<Integer> givenNumbers = Arrays.asList(2, 4, 6, 8, 10);
       int result = givenNumbers.stream().reduce(5, Integer::sum);
       System.out.println(result);
   }
}