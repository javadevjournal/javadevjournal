import java.util.List;
public class ExampleDiffAccumulatorCombiner {
   public static void main(String[] args) {
       List<String> numbers = Arrays.asList("one", "two", "three", "four", "five");
       String result = numbers.stream().reduce("=>", (first, second) -> first + "$" + second, (first, second) -> first + "%" + second);
       System.out.println(result);
   }
}