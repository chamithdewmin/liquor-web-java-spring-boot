package com.liqour.notificationservice.controller;

import com.liqour.notificationservice.model.Notification;
import com.liqour.notificationservice.service.NotificationService;
import com.itextpdf.text.DocumentException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<String> createAndSendNotification(
            @RequestParam String title,
            @RequestParam String message,
            @RequestParam String recipient) {
        try {
            Notification notification = notificationService.createNotification(title, message, recipient);
            notificationService.sendNotification(notification);
            return ResponseEntity.ok("Notification sent successfully.");
        } catch (MessagingException | DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send notification.");
        }
    }
}