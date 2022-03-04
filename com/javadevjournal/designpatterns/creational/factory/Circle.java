package javadevjournal.designpatterns.creational.factory;

/**
 * @author Kunwar
 */
public class Circle implements Shape {
   @Override
   public void drawShape() {
      System.out.println("Inside Circle::drawShape() method.");
   }
}