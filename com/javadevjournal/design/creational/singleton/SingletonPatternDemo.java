package javadevjournal.design.creational.singleton;

/**
 * @author Kunwar
 */
public class SingletonPatternDemo {
   public static void main(String[] args) {
      /* Let's create 3 objects and see their hashcode and they will be same. */
      System.out.println("in single threaded environment");
      Singleton singleton1 = Singleton.getInstance();
      Singleton singleton2 = Singleton.getInstance();
      Singleton singleton3 = Singleton.getInstance();
      System.out.println(singleton1.hashCode() +" "+ singleton2.hashCode() +" "+ singleton3.hashCode());

      System.out.println("in multi threaded environment");
      Thread1 t1 = new Thread1();
      t1.run();
      Thread2 t2 = new Thread2();
      t2.run();
      Thread3 t3 = new Thread3();
      t3.run();

   }
}