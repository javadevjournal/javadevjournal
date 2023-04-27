package main.com.kunwar.designpatterns.behavioral.observer;

public class ThirdSubscriber implements IObserver {
    @Override
    public void update(Update m) {
        System.out.println("MessageSubscriberThree :: " + m.getMessageContent());
    }
}