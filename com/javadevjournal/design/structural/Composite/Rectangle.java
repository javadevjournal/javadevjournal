package javadevjournal.design.structural.Composite;

/**
 * @author Kunwar
 */
public class Rectangle implements Shape {
    @Override
    public void drawShape(String color) {
        System.out.println("Drawing Rectangle with color " + color);
    }
}
