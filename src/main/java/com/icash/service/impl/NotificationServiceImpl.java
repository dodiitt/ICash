package com.icash.service.impl;

import com.icash.entity.Notification;
import com.icash.repository.NotificationRepository;
import com.icash.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Value("${notification.message.size}")
    private Integer size;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Page<Notification> getNotifications(String userID, Integer page) {
        if(page <= 0){
            page = 1;
        }
        return this.notificationRepository.findAllNotificationByUserIDAndIsDeletedIsTrue(userID, new PageRequest(page - 1, size, orderBy()));
    }

    private Sort orderBy() {
        return new Sort(Sort.Direction.DESC, "time");
    }
}
