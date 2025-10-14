package com.learning.cloud.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {

    private long id;

    private int quantity;
}
