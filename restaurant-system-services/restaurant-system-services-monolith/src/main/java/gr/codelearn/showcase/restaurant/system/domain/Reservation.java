package gr.codelearn.showcase.restaurant.system.domain;

import gr.codelearn.showcase.restaurant.commons.domain.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "reservations")
public class Reservation extends BaseModel {
	@ManyToOne
	private Customer customer;

	private LocalDateTime reservationTime;
	private String place;
	private int tableNumber;
}
