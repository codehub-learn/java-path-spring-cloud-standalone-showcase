package gr.codelearn.showcase.restaurant.system.api.resource;

import java.time.LocalDateTime;

public record ReservationResource(Long id, LocalDateTime reservationTime, int tableNumber, Long customerId) {
}
