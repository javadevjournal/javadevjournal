package main.com.kunwar.designpatterns.behavioral.observer;

public class ObserverPatternDemo {

    public static void main(String[] args) {
        FirstSubscriber firstSubscriber = new FirstSubscriber();
        SecondSubscriber secondSubscriber = new SecondSubscriber();
        ThirdSubscriber thirdSubscriber = new ThirdSubscriber();
         
        MessagePublisher p = new MessagePublisher();

        p.attach(firstSubscriber);
        p.attach(secondSubscriber);
         
        p.notifyUpdate(new Update("This is the first update"));   //s1 and s2 will receive the update
         
        p.detach(firstSubscriber);
        p.attach(thirdSubscriber);
         
        p.notifyUpdate(new Update("This is the second update")); //s2 and s3 will receive the update
    }
}