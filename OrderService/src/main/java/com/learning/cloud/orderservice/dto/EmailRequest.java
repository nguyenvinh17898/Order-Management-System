package com.learning.cloud.orderservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequest {
    private String to;

    private String subject;

    private String body;
}
