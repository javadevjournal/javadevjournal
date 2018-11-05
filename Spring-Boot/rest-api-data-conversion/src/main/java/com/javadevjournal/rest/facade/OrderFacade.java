package com.javadevjournal.rest.facade;

import com.javadevjournal.rest.data.Order;
import com.javadevjournal.rest.dto.OrderDto;
import com.javadevjournal.rest.service.OrderService;
import com.javadevjournal.rest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


public class OrderFacade {

    @Lazy
    @Autowired
    private OrderService orderService;

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    public OrderDto getOrderById(String id){
        userService.enableUser();
        return convertToOrderDto(orderService.getOrderById(id));
    }

    private OrderDto convertToOrderDto(Order order) {
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
    }

}
