package gr.codelearn.showcase.restaurant.system.repository;

import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}