import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        // Adding elements
        students.add("Alex");
        students.add("Bob");
        students.add("Mark");

        // Modifying elements
        students.set(1, "John");

        // Printing the ArrayList
        System.out.println(students); // Output: [Red, Yellow, Blue]
    }

    public static void removingElements(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(1001);
        numbers.add(1002);
        numbers.add(1003);

        // Removing an element
        numbers.remove(1);

        // Printing the ArrayList
        System.out.println(numbers); // Output: [10, 30]
    }
}