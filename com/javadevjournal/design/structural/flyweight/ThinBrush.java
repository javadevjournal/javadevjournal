package javadevjournal.design.structural.flyweight;

/**
 * @author Kunwar
 */
public class ThinBrush implements Brush {

    /*
      intrinsic state - shareable
     */
    final BrushSize brushSize = BrushSize.THIN;

    /*
      extrinsic state - supplied by client
     */
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing THIN '" + content + "' in color : " + color);
    }
}