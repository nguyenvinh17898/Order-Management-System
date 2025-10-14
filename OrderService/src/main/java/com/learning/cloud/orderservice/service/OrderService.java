package com.learning.cloud.orderservice.service;

import com.learning.cloud.orderservice.client.NotificationClient;
import com.learning.cloud.orderservice.dto.OrderRequest;
import com.learning.cloud.orderservice.dto.OrderResponse;
import com.learning.cloud.orderservice.entity.Order;
import com.learning.cloud.orderservice.entity.OrderDetail;
import com.learning.cloud.orderservice.repository.OrderDetailRepository;
import com.learning.cloud.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private NotificationClient notificationClient;

    public OrderResponse create(OrderRequest orderRequest) {
        // 1. Tìm user
        Order order = Order.builder()
                .userId(orderRequest.getUserId())
                .status("CREATED")
                .receiveAddress(orderRequest.getReceiveAddress())
                .createdAt(LocalDateTime.now())
                .build();

        Order savedOrder = orderRepository.save(order);

        List<OrderDetail> details = orderRequest.getOrderItemRequests().stream()
                .map(item -> OrderDetail.builder()
                        .order(savedOrder)
                        .productId(item.getId())
                        .price(1000.0)
                        .quantity(item.getQuantity())
                        .build())
                .toList();

        orderDetailRepository.saveAll(details);
        savedOrder.setOrderDetails(details);

        notificationClient.sendOrderSuccessMail("nguyenvinh17898@gmail.com");

        return OrderResponse.builder()
                .id(savedOrder.getId())
                .receiveAddress(savedOrder.getReceiveAddress())
                .status(savedOrder.getStatus())
                .orderItemRequests(orderRequest.getOrderItemRequests())
                .build();
    }
}
