import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamOperation {
    public static void main(String[] args) {
        // filter()
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> evenStream = intStream.filter(e -> (e % 2 == 0));

        evenStream.forEach(e -> System.out.print(e+" "));

        //map()
        Stream<Integer> intStream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> mapStream = intStream1.map(e -> e * 10);

        mapStream.forEach(e -> System.out.print(e + " "));

        //sorted()
        Stream<Integer> intStream3 = Stream.of(4,22,1,7,5,10);
        Stream<Integer> sortedStream = intStream3.sorted();

        sortedStream.forEach(e -> System.out.print(e + " "));

        //foreach()
        Stream<Integer> intStream4 = Stream.of(1, 2, 3, 4, 5, 6, 7);
        intStream4.forEach(e -> System.out.print(e * 3 + " "));

        //using a map :
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.forEach((key,value) -> System.out.println("Key: "+key+" Value: "+value));

        //reduce
        Stream<Integer> intStream5 = Stream.of(1, 2, 3, 4);
        //reduce will add each element of the stream
        Optional<Integer> optionalResult = intStream5.reduce((i, j) -> i + j);
        System.out.println(optionalResult.get());

        //count
        Stream<Integer> intStream6 = Stream.of(1, 2, 3, 4);
        System.out.println("Total elements "+intStream6.count());

        //collect()
        Stream<Integer> intStream7 = Stream.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> intList = intStream7.collect(Collectors.toList());
        System.out.print(intList);

        //match()
        List<String> strList = new ArrayList<>();
        strList.add("Sun");
        strList.add("Mon");
        strList.add("Tues");

        //check if any value in the list starts with 'T'
        System.out.println(strList.stream().anyMatch(e -> e.startsWith("T")));

        //check if all values in the list start with 'T'
        System.out.println(strList.stream().allMatch(e -> e.startsWith("T")));

        //check if none of the values in the list starts with 'X'
        System.out.println(strList.stream().noneMatch(e -> e.startsWith("X")));
    }
}
