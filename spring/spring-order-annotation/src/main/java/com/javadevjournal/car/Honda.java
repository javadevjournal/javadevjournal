package com.javadevjournal.car;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Honda implements Car {

    @Override
    public String getCarRecommendation() {
        return "Honda";
    }
}
