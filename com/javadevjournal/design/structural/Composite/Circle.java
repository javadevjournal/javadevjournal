package javadevjournal.design.structural.Composite;

/**
 * @author Kunwar
 */
public class Circle implements Shape {

    @Override
    public void drawShape(String color) {
        System.out.println("Drawing Circle with color " + color);
    }
}