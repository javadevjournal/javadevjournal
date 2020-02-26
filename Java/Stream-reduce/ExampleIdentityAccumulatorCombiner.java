import java.util.Arrays;
import java.util.List;
public class ExampleIdentityAccumulatorCombiner {
   public static void main(String[] args) {
       List<String> numbers = Arrays.asList("one", "two", "three", "four", "five");
       String result = numbers.parallelStream().reduce(" ", (first, second) -> first + second, String::concat);
       System.out.println(result);
   }
}