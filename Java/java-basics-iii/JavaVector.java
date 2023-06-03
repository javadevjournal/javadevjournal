import java.util.Vector;

public class JavaVector {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");

        String secondFruit = vector.get(1);
        System.out.println("Second fruit: " + secondFruit);

        vector.remove("Banana");
        vector.removeElementAt(0);

        for (String fruit : vector) {
            System.out.println(fruit);
        }

        int size = vector.size();
        int capacity = vector.capacity();

        System.out.println("Size: " + size);
        System.out.println("Capacity: " + capacity);

    }
}