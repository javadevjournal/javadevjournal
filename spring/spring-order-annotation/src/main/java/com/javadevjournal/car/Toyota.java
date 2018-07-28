package com.javadevjournal.car;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Toyota implements Car {

    @Override
    public String getCarRecommendation() {
        return "Toyota";
    }
}
