package javadevjournal.design.structural.flyweight;

/**
 * @author Kunwar
 */
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        // New thick Red Brush
        Brush redThickBrush1 = BrushFactory.getThickBrush("RED");
        redThickBrush1.draw("Hello There !!");

        // Red Brush is shared
        Brush redThickBrush2 = BrushFactory.getThickBrush("RED");
        redThickBrush2.draw("Hello There Again !!");

        System.out.println("Hashcode: " + redThickBrush1.hashCode());
        System.out.println("Hashcode: " + redThickBrush2.hashCode());

        // New thin Blue Brush
        Brush blueThinBrush1 = BrushFactory.getThinBrush("BLUE");   //created new pen
        blueThinBrush1.draw("Hello There !!");

        // Blue Brush is shared
        Brush blueThinBrush2 = BrushFactory.getThinBrush("BLUE");   //created new pen
        blueThinBrush2.draw("Hello There Again!!");

        System.out.println("Hashcode: " + blueThinBrush1.hashCode());
        System.out.println("Hashcode: " + blueThinBrush2.hashCode());

        // New MEDIUM Yellow Brush
        Brush yellowThinBrush1 = BrushFactory.getMediumBrush("YELLOW");   //created new pen
        yellowThinBrush1.draw("Hello There !!");

        // Yellow brush is shared
        Brush yellowThinBrush2 = BrushFactory.getMediumBrush("YELLOW");   //created new pen
        yellowThinBrush2.draw("Hello There Again!!");

        System.out.println("Hashcode: " + yellowThinBrush1.hashCode());
        System.out.println("Hashcode: " + yellowThinBrush2.hashCode());
    }
}