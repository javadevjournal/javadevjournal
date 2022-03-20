package javadevjournal.design.creational.abstractfactory.example2;

/**
 * Factory Producer
 */
public class MpbileFactoryProducer {
       public static AbstractFactory getFactory(boolean isApple){
          if(isApple){
             return new AppleMobileFactory();         
          }else{
             return new AndroidMobileFactory();
          }
       }
}
  