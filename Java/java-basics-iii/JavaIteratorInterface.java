import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaIteratorInterface {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }

    public static void iteratorExample() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.equals("Banana")) {
                iterator.remove();
            }
        }

        System.out.println(fruits); // Output: [Apple, Orange]
    }
}