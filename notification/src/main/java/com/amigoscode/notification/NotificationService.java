package com.amigoscode.notification;

import com.amigoscode.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void notify(NotificationRequest request) {
        repository.save(Notification
                .builder()
                        .toCustomerId(request.toCustomerId())
                        .toCustomerEmail(request.toCustomerEmail())
                        .message(request.message())
                        .sender("amigoscode")
                        .sentAt(LocalDateTime.now())
                .build());
    }
}
