package com.javadevjournal.controller;

import com.javadevjournal.model.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class CartPageController {

    @GetMapping("/cart")
    public String cart(@SessionAttribute("shoppingCart") ShoppingCart cart, final Model model){
        model.addAttribute("cart", cart);
        return "cart";
    }
}
