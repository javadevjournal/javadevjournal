package javadevjournal.design.structural.flyweight;

import java.util.HashMap;

/**
 * @author Kunwar
 */
public class BrushFactory {

    private static final HashMap<String, Brush> brushMap = new HashMap<>();

    public static Brush getThickBrush(String color) {
        String key = color + "-THICK";
        Brush brush = brushMap.get(key);

        if (brush != null) {
            return brush;
        } else {
            brush = new ThickBrush();
            brush.setColor(color);
            brushMap.put(key, brush);
        }
        return brush;
    }

    public static Brush getThinBrush(String color) {
        String key = color + "-THIN";
        Brush brush = brushMap.get(key);

        if (brush != null) {
            return brush;
        } else {
            brush = new ThinBrush();
            brush.setColor(color);
            brushMap.put(key, brush);
        }

        return brush;
    }

    public static Brush getMediumBrush(String color) {
        String key = color + "-MEDIUM";
        Brush brush = brushMap.get(key);

        if (brush != null) {
            return brush;
        } else {
            brush = new MediumBrush();
            brush.setColor(color);
            brushMap.put(key, brush);
        }

        return brush;
    }
}