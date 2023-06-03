import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JavaListIterator {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("John");
        myList.add("Jane");
        myList.add("Bob");

        ListIterator<String> listIterator = myList.listIterator();

        while (listIterator.hasNext()) {
            String element = listIterator.next();
            System.out.println(element); // Print the current element

            // Modify the current element
            if (element.equals("Jane")) {
                listIterator.set("Janet");
            }

            // Add a new element after "Bob"
            if (element.equals("Bob")) {
                listIterator.add("Alice");
            }
        }

        System.out.println(myList); // Print the modified list
    }
}
