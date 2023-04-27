package main.com.kunwar.designpatterns.behavioral.observer;

public interface ISubject {
    public void attach(IObserver o);
    public void detach(IObserver o);
    public void notifyUpdate(Update m);
}