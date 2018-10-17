package com.icash.service;

import com.icash.entity.Notification;
import org.springframework.data.domain.Page;

public interface NotificationService {
    Page<Notification> getNotifications(String userID, Integer page);
}
