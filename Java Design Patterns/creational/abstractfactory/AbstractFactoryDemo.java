package javadevjournal.design.creational.abstractfactory;

/**
 * @author Kunwar
 */
public class AbstractFactoryDemo {
   public static void main(String[] args) {
      /* get shape factory */
      AbstractFactory shapeFactory = FactoryOfFactory.getFactory(false);
      /* get an object of Shape Rectangle */
      Shape shape1 = shapeFactory.getShape("RECTANGLE");
      /* call draw method of Shape Rectangle */
      shape1.drawShape();
      /* get an object of Shape Square */
      Shape shape2 = shapeFactory.getShape("SQUARE");
      /* call draw method of Shape Square */
      shape2.drawShape();
      /* get rounded shape factory */
      AbstractFactory roundShapeFactory = FactoryOfFactory.getFactory(true);
      /* get an object of Shape Rectangle */
      Shape shape3 = roundShapeFactory.getShape("RECTANGLE");
      /* call draw method of Shape Rectangle */
      shape3.drawShape();
      /* get an object of Shape Square */
      Shape shape4 = roundShapeFactory.getShape("SQUARE");
      /* call draw method of Shape Square */
      shape4.drawShape();
   }
}