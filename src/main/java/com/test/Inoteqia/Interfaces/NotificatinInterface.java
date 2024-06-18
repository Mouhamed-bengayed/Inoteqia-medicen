package com.test.Inoteqia.Interfaces;

import com.test.Inoteqia.Entity.Notification;

import java.util.List;

public interface NotificatinInterface {
    Notification createNotification(Notification notification);
    Notification getNotification(Long id);
    //  Notification updateNotification(Notification notification);
    void deleteNotification(Long id);
    List<Notification> getAllNotifications();
    List<Notification> getNotificationByuser(Long id);
}
