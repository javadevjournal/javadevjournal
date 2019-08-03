package spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class TryAdvanceExample {

    public static void main(String[] args){
        List<String> values = new ArrayList<>();

        values.add("one");
        values.add("two");
        values.add("three");

        Spliterator<String> stringSpliterator = values.spliterator();

        while(stringSpliterator.tryAdvance(System.out::println)){
            //inside while loop
        }
    }
}
