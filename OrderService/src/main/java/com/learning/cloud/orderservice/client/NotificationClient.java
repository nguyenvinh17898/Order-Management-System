package com.learning.cloud.orderservice.client;

import com.learning.cloud.orderservice.dto.EmailRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class NotificationClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendOrderSuccessMail(String to) {

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
        String authHeader = request.getHeader("Authorization");

        // ✅ Chuẩn bị header cho request sang NotificationService
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (authHeader != null) {
            headers.set("Authorization", authHeader);
        }

        EmailRequest mail = EmailRequest.builder()
                .to(to)
                .subject("Your Order is confirmed!")
                .body("Hi! Your order has been successfully placed.")
                .build();

        HttpEntity<EmailRequest> entity = new HttpEntity<>(mail, headers);

        restTemplate.postForObject("http://localhost:8082/api/notify/sendEmail", entity, String.class);
    }
}
