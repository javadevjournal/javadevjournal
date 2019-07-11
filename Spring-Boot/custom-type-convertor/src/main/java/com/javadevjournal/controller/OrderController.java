package com.javadevjournal.controller;

import com.javadevjournal.data.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger LOG= LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/order/{date}")
    public Order getOrderByDate(@PathVariable("date")LocalDate date){

        LOG.info("Sending order for the request date {} ", date);
        return new Order(300.40, "1234",date);
    }
}
