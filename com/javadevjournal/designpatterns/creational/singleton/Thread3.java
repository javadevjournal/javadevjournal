package javadevjournal.designpatterns.creational.singleton;

public class Thread3 implements  Runnable{
    @Override
    public void run() {
        SingletonMultiThreaded singletonMultiThreaded = SingletonMultiThreaded.getInstance();
        System.out.println(singletonMultiThreaded.hashCode());
    }
}
