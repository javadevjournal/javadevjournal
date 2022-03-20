package javadevjournal.design.creational.abstractfactory;

/**
 * @author Kunwar
 */
public class RoundedSquare implements Shape {
   @Override
   public void drawShape() {
      System.out.println("Inside RoundedSquare::draw() method.");
   }
}