package com.javadevjournal.car;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class UsedCar implements Car {

    @Override
    public String getCarRecommendation() {
        return "Certified Car";
    }
}
