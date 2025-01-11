package com.basicmicroservice.cartservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/getData")
    public String getCartData() {
        return "Returning data from CART-SERVICE";
    }
}
