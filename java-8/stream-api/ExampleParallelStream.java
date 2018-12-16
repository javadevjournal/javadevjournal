import java.util.ArrayList;
import java.util.List;

public class ExampleParallelStream {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        intList.parallelStream().
                filter(e -> {
                    System.out.println("filter " + e);
                    return true;
                }).
                forEach(e -> System.out.println("ForEach " + e));
    }

}
