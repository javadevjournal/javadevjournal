package javadevjournal.design.creational.abstractfactory.example2;

/**
 * Client Class
 */
public  class AbstractFactoryPatternDemo{
       public static void main(String[] args){
          AbstractFactory abstractFactory1 = MpbileFactoryProducer.getFactory(false);
          IMobile onePlus = abstractFactory1.getMobile("Oneplus");
          onePlus.brandName();
          IMobile sony =  abstractFactory1.getMobile("Sony");
          sony.brandName();
           IMobile lava =  abstractFactory1.getMobile("Lava");
           lava.brandName();
          AbstractFactory abstractFactory2 = MpbileFactoryProducer.getFactory(true);
          IMobile iphone = abstractFactory2.getMobile("iphone");
          iphone.brandName();
       }
}