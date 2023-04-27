package main.com.kunwar.designpatterns.behavioral.observer;

public class FirstSubscriber implements IObserver {
    @Override
    public void update(Update m) {
        System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
    }
}