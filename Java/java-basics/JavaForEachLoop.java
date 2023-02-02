import java.util.*;

public class JavaForEachLoop {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Bob");
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void forEachLoop(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Jane", 30);
        ages.put("Bob", 35);

        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old.");
        }
    }


}
