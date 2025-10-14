package com.learning.cloud.orderservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private Long id;

    private String receiveAddress;

    private String status;

    private List<OrderItemRequest> orderItemRequests;
}
