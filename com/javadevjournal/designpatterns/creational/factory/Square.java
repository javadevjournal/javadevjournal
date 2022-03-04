package javadevjournal.designpatterns.creational.factory;

/**
 * @author Kunwar
 */
public class Square implements Shape {
   @Override
   public void drawShape() {
      System.out.println("Inside Square::drawShape() method.");
   }
}