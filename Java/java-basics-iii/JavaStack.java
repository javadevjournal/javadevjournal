import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push("Java");
        stack.push("is");
        stack.push("awesome");

        // Popping elements from the stack
        String element = stack.pop();
        System.out.println("Popped element: " + element);

        // Peeking at the topmost element
        String topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // Checking if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is stack empty? " + isEmpty);

        // Getting the size of the stack
        int size = stack.size();
        System.out.println("Stack size: " + size);
    }
}
