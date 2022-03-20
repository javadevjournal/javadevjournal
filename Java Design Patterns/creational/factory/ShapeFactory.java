package javadevjournal.design.creational.factory;

/**
 * @author Kunwar
 * Factory Pattern Implementation here
 */
public class ShapeFactory {
   /**
    * get the shapeType from caller and decide the correct implementation class
    * @param shapeType
    * @return
    */
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }		
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
         
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
         
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      return null;
   }
}