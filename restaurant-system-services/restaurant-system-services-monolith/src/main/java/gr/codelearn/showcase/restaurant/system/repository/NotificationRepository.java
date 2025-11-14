package gr.codelearn.showcase.restaurant.system.repository;

import gr.codelearn.showcase.restaurant.system.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}