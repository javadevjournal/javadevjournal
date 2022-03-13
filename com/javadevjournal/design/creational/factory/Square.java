package javadevjournal.design.creational.factory;

/**
 * @author Kunwar
 */
public class Square implements Shape {
   @Override
   public void drawShape() {
      System.out.println("Inside Square::drawShape() method.");
   }
}