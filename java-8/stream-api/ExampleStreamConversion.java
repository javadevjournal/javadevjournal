import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamConversion {
        public static void main(String[] args) {
            //stream to list
            //1
            Stream<Integer> numStream = Stream.of(1,2,3,4,5,6,7);
            List<Integer> numList = numStream.collect(Collectors.toList());
            System.out.println(numList);

            //2
            numStream = Stream.of(1,2,3,4,5,6,7);
            List<Integer> numList1  = numStream.collect(Collectors.toCollection(ArrayList::new));

            //3
            Stream<Integer> numStream2 = Stream.of(1,2,3,4,5,6,7);
            List<Integer> numList2 = new ArrayList<>();
            numStream2.forEach(numList::add);

            //stream to map
            Stream<String[]> mapStream = Stream.of(new String[][]{{"1", "one"}, {"2", "two"}});
            Map<String, String> finalMap = mapStream.collect(Collectors.toMap(e -> e[0], e -> e[1]));
            System.out.println(finalMap);

            //stream to array
            //1
            Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6);
            Integer[] intArray = intStream.toArray(Integer[]::new);
            System.out.println(Arrays.toString(intArray));

            //2
            Stream<Integer> intStream2 = Stream.of(1, 2, 3, 4, 5, 6);
            int[] intArray2 = intStream2.mapToInt(i -> i).toArray();
        }
}
