package javadevjournal.design.structural.Composite;

/**
 * @author Kunwar
 */
public class Square implements Shape {
    @Override
    public void drawShape(String color) {
        System.out.println("Drawing Square with color " + color);
    }
}
