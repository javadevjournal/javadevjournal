package main.com.kunwar.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
 
public class MessagePublisher implements ISubject {
     
    private List<IObserver> observers = new ArrayList<>();

    ////in multithreaded environment, please use thread-safe collections
    @Override
    public void attach(IObserver o) {
        observers.add(o);
    }

    //in multithreaded environment, please use thread-safe collections
    @Override
    public void detach(IObserver o) {
        observers.remove(o);
    }
 
    @Override
    public void notifyUpdate(Update m) {
        for(IObserver o: observers) {
            o.update(m);
        }
    }
}