package main.com.kunwar.designpatterns.behavioral.observer;

public class SecondSubscriber implements IObserver {
    @Override
    public void update(Update m) {
        System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());
    }
}
