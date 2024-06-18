package com.test.Inoteqia.ServiceIMP;

import com.test.Inoteqia.Entity.Notification;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Interfaces.NotificatinInterface;
import com.test.Inoteqia.Reposotories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceIMP implements NotificatinInterface {
    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotification(Long id) {
        return notificationRepository.getById(id);
    }



    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getNotificationByuser(Long id) {
        List<Notification> listNotifications = notificationRepository.findAll();
        List<Notification> userNotifications = new ArrayList<>();
        for (Notification notification : listNotifications){
            for (Utilisateur recipient : notification.getRecipients()){
                if (recipient.getId().equals(id)){
                    userNotifications.add(notification);
                    break;
                }
            }
        }
        return userNotifications;
    }
}