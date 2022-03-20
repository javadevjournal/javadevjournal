package javadevjournal.design.creational.singleton.breakit;

import java.lang.reflect.Constructor;

/**
 * @author Kunwar
 */
public class BreakSingletonUsingReflection {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.instance;
        Singleton singleton2 = null;
        try {
            Constructor[] constructors =
                    Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                singleton2 = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("instance1.hashCode(): " + singleton1.hashCode());
        System.out.println("instance2.hashCode(): " + singleton2.hashCode());
    }
}
