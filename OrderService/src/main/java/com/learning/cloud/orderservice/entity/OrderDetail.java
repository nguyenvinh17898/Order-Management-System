package com.learning.cloud.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Long productId;

    private Double price;

    private Integer quantity;
}
