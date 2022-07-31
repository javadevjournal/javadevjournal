package javadevjournal.design.structural.flyweight;

/**
 * @author Kunwar
 */
public class MediumBrush implements Brush {

    /*
      intrinsic state - shareable
     */
    final BrushSize brushSize = BrushSize.MEDIUM;

    /*
      extrinsic state - supplied by client
     */
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing MEDIUM '" + content + "' in color : " + color);
    }
}