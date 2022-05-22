package javadevjournal.design.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunwar
 */

public class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<String, Shape>();

    /**
     * Return cloned object of Shape class implementing classes.
     *
     * @param shapeId
     * @return
     */
    public static Shape getShape(String shapeId) {
        Shape toBeClonedShape = shapeMap.get(shapeId);
        return (Shape) toBeClonedShape.clone();
    }


    /**
     * In real-world applications, the loading of details will be from a Database.
     * We are using a HaspMap to demonstrate the same behavior.
     */
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}