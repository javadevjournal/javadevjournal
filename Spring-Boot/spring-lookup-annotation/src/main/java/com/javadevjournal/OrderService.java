package com.javadevjournal;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    public void sendOrderNotificationMsg(){

        PlaceOrderNotification notification = getPlaceOrderNotification();

        //This will create a new instance every time  we call notification method
    }

    public PlaceOrderNotification getPlaceOrderNotification(){

        // This implementation will be overridden by dynamically generated subclass
        return  null;
    }
}
