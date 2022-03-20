package javadevjournal.design.creational.abstractfactory.example2;

/**
 * Apple Mobile Factory
 */
public class AppleMobileFactory extends AbstractFactory{
       @Override
       public IMobile getMobile(String mobileModel){
          if(mobileModel.equalsIgnoreCase("iphone")){
             return new Iphone();         
          } 
          return null;
       }
}