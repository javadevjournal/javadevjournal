package com.javadevjournal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PlaceOrderNotification {

    public String getNotification(){
        return  "Order Placed";
    }
}
