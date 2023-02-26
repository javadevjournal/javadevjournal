package javadevjournal.design.structural.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kunwar
 */
public class Drawing implements Shape {

    private List<Shape> shapesList = new ArrayList<Shape>();

    @Override
    public void drawShape(String fillColor) {
        for (Shape shape : shapesList) {
            shape.drawShape(fillColor);
        }
    }

    //adding shape to drawing
    public void add(Shape s) {
        this.shapesList.add(s);
    }

    //removing shape from drawing
    public void remove(Shape s) {
        shapesList.remove(s);
    }

    //removing all the shapes
    public void clear() {
        System.out.println("Clearing all the shapes from drawing");
        this.shapesList.clear();
    }
}