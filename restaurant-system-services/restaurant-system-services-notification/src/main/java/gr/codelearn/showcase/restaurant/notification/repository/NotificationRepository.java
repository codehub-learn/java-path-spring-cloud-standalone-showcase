package gr.codelearn.showcase.restaurant.notification.repository;

import gr.codelearn.showcase.restaurant.notification.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}