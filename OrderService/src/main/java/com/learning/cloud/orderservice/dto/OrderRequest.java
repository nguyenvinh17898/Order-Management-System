package com.learning.cloud.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderRequest {

    private long userId;

    private String receiveAddress;

    private List<OrderItemRequest> orderItemRequests;

}
