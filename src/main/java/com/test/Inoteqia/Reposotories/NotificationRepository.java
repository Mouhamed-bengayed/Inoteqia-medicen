package com.test.Inoteqia.Reposotories;
import com.test.Inoteqia.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n JOIN n.groupeMeds gm JOIN gm.medecins m WHERE m.id = :id")
    List<Notification> findNotificationsByUserId(@Param("id") Long id);
}