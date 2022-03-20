package javadevjournal.design.creational.factory;

/**
 * @author Kunwar
 * Factory Pattern Demo
 */
public class FactoryPatternDemo {
   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      /* get an object of Circle Class and call its drawShape method. */
      Shape shape1 = shapeFactory.getShape("CIRCLE");
      shape1.drawShape();

      /* get an object of Rectangle Class and call its drawShape method. */
      Shape shape2 = shapeFactory.getShape("RECTANGLE");
      shape2.drawShape();

      /* get an object of Square Class and call its drawShape method. */
      Shape shape3 = shapeFactory.getShape("SQUARE");
      shape3.drawShape();
   }
}