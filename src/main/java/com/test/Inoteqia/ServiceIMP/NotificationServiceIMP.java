package com.test.Inoteqia.ServiceIMP;

import com.test.Inoteqia.DTO.NotifDTO;
import com.test.Inoteqia.Entity.GroupeMed;
import com.test.Inoteqia.Entity.Notification;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Interfaces.NotificatinInterface;
import com.test.Inoteqia.Reposotories.GroupeMedReposotory;
import com.test.Inoteqia.Reposotories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NotificationServiceIMP implements NotificatinInterface {
    @Autowired
    NotificationRepository notificationRepository;
    GroupeMedReposotory groupeMedReposotory;
    @Override
    public Notification createNotification(NotifDTO notification) {

        Notification notification1 = new Notification();
        notification1.setDate(notification.getDate());
        notification1.setTitle(notification.getTitle());
        notification1.setMessage(notification.getDescription());
        notification1.setRappel(notification.getReminder());
//        notification1.setFile(notification.getFile());
        List<Long>groupeMedsId=notification.getMedecins();

        for (Long id : groupeMedsId){
            Optional<GroupeMed> groupeMeds = groupeMedReposotory.findById(id);
            notification1.getGroupeMeds().add(groupeMeds.get());
        }
        return notificationRepository.save(notification1);
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

//    @Override
//    public List<Notification> getNotificationByuser(Long id) {
//        List<Notification> listNotifications = notificationRepository.findAll();
//        List<Notification> userNotifications = new ArrayList<>();
//        for (Notification notification : listNotifications){
//            List <GroupeMed> GroupeMedrecipient = notification.getGroupeMeds();
//            for (GroupeMed grp : GroupeMedrecipient){
//                for(Utilisateur recipient : grp.getMedecins()){
//                    if (recipient.getId().equals(id)){
//                        userNotifications.add(notification);
//                    }
//                }
//
//            }
//        }
//        return userNotifications;
//    }
    @Override
    public List<Notification> getNotificationByuser(Long id) {
        return notificationRepository.findNotificationsByUserId(id);
    }
//    @Override
//    public  List<Notification> getNotificationforAdmin(Long id){
//        return notificationRepository.findAllByAdministrateursContains(id);
//    }
}