package javadevjournal.design.creational.singleton;

public class Thread2 implements  Runnable{
    @Override
    public void run() {
        SingletonMultiThreaded singletonMultiThreaded = SingletonMultiThreaded.getInstance();
        System.out.print(singletonMultiThreaded.hashCode() + " ");
    }
}
