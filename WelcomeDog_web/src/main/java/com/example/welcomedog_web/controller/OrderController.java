package com.example.welcomedog_web.controller;

import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_web.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute OrderDTO.Request request) {
        orderService.createOrder(request);
        return "page/main";
    }
}
