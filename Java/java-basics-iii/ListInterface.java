import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        // Adding elements to the list
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Printing the list
        System.out.println(fruits); // Output: [Apple, Banana, Orange]
    }

    public static void modifyElements() {
        List<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        // Accessing elements
        String firstColor = colors.get(0);
        System.out.println("First color: " + firstColor); // Output: First color: Red

        // Modifying elements
        colors.set(1, "Yellow");
        System.out.println(colors); // Output: [Red, Yellow, Blue]
    }

    public static void removeElements() {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Removing an element
        numbers.remove(1); // Remove element at index 1

        System.out.println(numbers); // Output: [10, 30]
    }
}