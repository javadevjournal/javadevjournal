package javadevjournal.designpatterns.creational.abstractfactory;

/**
 * @author Kunwar
 */
public class RoundedRectangle implements Shape {
   @Override
   public void drawShape() {
      System.out.println("Inside RoundedRectangle::draw() method.");
   }
}