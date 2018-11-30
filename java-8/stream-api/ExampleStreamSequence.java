import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ExampleStreamSequence {
    public static void main(String[] args) {
        Set<Integer> intSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Object[] array = intSet.stream().parallel().limit(8).toArray();
        Object[] array1 = intSet.stream().unordered().parallel().limit(8).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
    }

}
