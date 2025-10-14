package com.learning.cloud.orderservice.controller;

import com.learning.cloud.orderservice.dto.OrderRequest;
import com.learning.cloud.orderservice.dto.OrderResponse;
import com.learning.cloud.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // POST /api/orders
    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.create(orderRequest);
        return ResponseEntity.ok(orderResponse);
    }
}
