package spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class ForEachRemainingExample {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();

        values.add(1);
        values.add(2);
        values.add(3);

        Spliterator<Integer> integerSpliterator = values.spliterator();
        integerSpliterator.forEachRemaining(System.out::println);

    }
}


