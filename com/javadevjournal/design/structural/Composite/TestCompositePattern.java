package javadevjournal.design.structural.Composite;

/**
 * @author Kunwar
 */
public class TestCompositePattern {

    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape triangle1 = new Triangle();
        Shape circle = new Circle();
        Shape square = new Square();
        Shape rectangle = new Rectangle();

        Drawing drawing = new Drawing();
        drawing.add(triangle1);
        drawing.add(triangle1);
        drawing.add(circle);
        drawing.add(square);
        drawing.add(rectangle);
        drawing.drawShape("Red");

        drawing.clear();

        drawing.add(triangle);
        drawing.add(circle);
        drawing.add(square);
        drawing.add(rectangle);
        drawing.drawShape("Blue");
    }
}