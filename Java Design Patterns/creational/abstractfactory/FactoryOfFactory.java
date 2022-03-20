package javadevjournal.design.creational.abstractfactory;

/**
 * @author Kunwar
 */
public class FactoryOfFactory {
   public static AbstractFactory getFactory(boolean rounded){   
      if(rounded){
         return new RoundedShapeFactory();         
      }else{
         return new ShapeFactory();
      }
   }
}