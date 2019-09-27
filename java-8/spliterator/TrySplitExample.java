package spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class TrySplitExample {


    public static void main(String[] args) {
        List<String> values = new ArrayList<>();

        values.add("one");
        values.add("two");
        values.add("three");
        values.add("four");
        values.add("five");
        values.add("six");
        values.add("seven");
        values.add("eight");
        values.add("nine");
        values.add("ten");

        Spliterator<String> firstSpliterator = values.spliterator();
        Spliterator<String> secondSpliterator = firstSpliterator.trySplit();
        Spliterator<String> thirdSpliterator = firstSpliterator.trySplit();

        System.out.println("firstSpliterator : ");
        while (firstSpliterator.tryAdvance(System.out::println)) {
            //inside while loop
        }

        System.out.println("secondSpliterator : ");
        while (secondSpliterator.tryAdvance(System.out::println)) {
            //inside while loop
        }

        System.out.println("thirdSpliterator : ");
        while (thirdSpliterator.tryAdvance(System.out::println)) {
            //inside while loop
        }
    }
}

