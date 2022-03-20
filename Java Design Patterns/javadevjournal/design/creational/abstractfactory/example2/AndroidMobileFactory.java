package javadevjournal.design.creational.abstractfactory.example2;

/**
 * Android Mobile Factory
 */
public class AndroidMobileFactory extends AbstractFactory {
       @Override
       public IMobile getMobile(String mobileModel){
          if(mobileModel.equalsIgnoreCase("Oneplus")){
             return new OnePlus();         
          }else if(mobileModel.equalsIgnoreCase("Sony")){
             return new Sony();
          }else if(mobileModel.equalsIgnoreCase("Lava")){
              return new Lava();
          }
          return null;
       }
}