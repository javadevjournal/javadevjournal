package javadevjournal.design.creational.singleton;

public class SingletonMultiThreaded {

    /* private instance variable  */
    private static volatile SingletonMultiThreaded INSTANCE;
  
    /* private constructor */
    private SingletonMultiThreaded() { }

    public static SingletonMultiThreaded getInstance() {
        /* double-checking lock */
        if(null == INSTANCE){
            /* synchronized block */
            synchronized (SingletonMultiThreaded.class) {
                if(null == INSTANCE){
                    INSTANCE = new SingletonMultiThreaded();
                }
            }
        }
        return INSTANCE;
    }
}