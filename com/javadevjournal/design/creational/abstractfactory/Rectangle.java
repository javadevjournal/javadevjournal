package javadevjournal.design.creational.abstractfactory;

/**
 * @author Kunwar
 */
public class Rectangle implements Shape {
   @Override
   public void drawShape() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}