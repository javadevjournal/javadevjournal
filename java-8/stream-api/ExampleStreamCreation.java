import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ExampleStreamCreation {
    public static void main(String[] args) {
        //Stream from values
        Stream stream = Stream.of(1);
        Stream<Character> charStream = Stream.of('a', 'b', 'c');
        Stream<String> strStream = Stream.of("Hello", "World");

        //Stream from a string
        IntStream intStream = "Hello World !!".chars();
        IntStream intStream1 = "Hello World !!".codePoints();

        //stream from pattern
        Pattern p = Pattern.compile(",");
        StringBuilder stringBuilder = new StringBuilder("1,2,3,4,5");
        Stream<String> patternStream = p.splitAsStream(stringBuilder);

        //stream from array
        Stream<Integer> intStream2 = Stream.of(new Integer[]{1, 2, 3, 4, 5});
        IntStream intStream3 = Arrays.stream(new int[]{1, 2, 3, 4});

        int[] mainArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        IntStream s = Arrays.stream(mainArray, 2, 5);

        //stream from collection
        List<String> wordList = new ArrayList<>();
        wordList.add("Hello");
        wordList.add("World");

        Stream wordStream = wordList.stream();
        Stream parallelWordStream = wordList.parallelStream();

        //from a set
        Set set = new HashSet();
        set.add("First element");
        set.add("Second element");
        set.add("Third element");

        Stream setStream = set.stream();

        //empty stream
        Stream emptyStream = Stream.empty();
        Stream emptyStream1 = Stream.of();

        //from generate
        Stream.generate(new Random()::nextInt).limit(6).forEach(System.out::println);

        //from iterate
        Stream.iterate(3, n -> n + 1).limit(6).forEach(System.out::println);

        //from file
        try {
            Stream<String> fileStream = Files.lines(Paths.get("C:\\sample.txt"));
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Optional<String> lineWithStreamWord = Files.lines(Paths.get("C:\\sample.txt")).filter(s1 -> s1.contains("stream")).findFirst();
            if (lineWithStreamWord.isPresent()) {
                System.out.println(lineWithStreamWord.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}