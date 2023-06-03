import java.util.ArrayList;
import java.util.List;

public class ArraListAndLinkedList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.remove(1);
        System.out.println(names); // Output: [John, Bob]
    }

    public static void linkedListExample(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.remove(1);
        System.out.println(names); // Output: [John, Bob]
    }
}