package com.icash.repository;

import com.icash.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends PagingAndSortingRepository<Notification, String> {
    Page<Notification> findAllNotificationByUserIDAndIsDeletedIsTrue(String userID, Pageable page);
}
