package javadevjournal.design.structural.flyweight;

/**
 * @author Kunwar
 */
public class ThickBrush implements Brush {
    /*
      intrinsic state - shareable
     */
    final BrushSize brushSize = BrushSize.THICK;

    /*
      extrinsic state - supplied by client
     */
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing THICK '" + content + "' in color : " + color);
    }
}