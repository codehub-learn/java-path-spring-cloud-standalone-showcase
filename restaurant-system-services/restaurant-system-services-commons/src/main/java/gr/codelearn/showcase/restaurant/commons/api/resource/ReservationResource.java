package gr.codelearn.showcase.restaurant.commons.api.resource;

import java.time.LocalDateTime;

public record ReservationResource(Long id, LocalDateTime reservationTime, String place, int tableNumber, CustomerResource customer) {
}
