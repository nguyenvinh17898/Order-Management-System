package com.learning.cloud.notificationservice.controller;

import com.learning.cloud.notificationservice.dto.EmailRequest;
import com.learning.cloud.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    // POST /api/orders
    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequest emailRequest) {
        emailService.sendOrderSuccessMail(emailRequest);
        return ResponseEntity.ok("Email sent successfully");
    }
}
