package main.com.kunwar.designpatterns.behavioral.observer;

public class Update {
    final String messageContent;
     
    public Update(String m) {
        this.messageContent = m;
    }
 
    public String getMessageContent() {
        return messageContent;
    }
}