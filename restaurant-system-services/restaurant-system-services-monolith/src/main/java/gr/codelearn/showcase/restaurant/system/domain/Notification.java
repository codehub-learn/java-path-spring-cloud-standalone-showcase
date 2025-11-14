package gr.codelearn.showcase.restaurant.system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "notifications")
public class Notification extends BaseModel {
	private String recipient;
	private String message;
	private ZonedDateTime sentAt = ZonedDateTime.now();

	public Notification(final String recipient, final String message) {
		this.recipient = recipient;
		this.message = message;
	}
}
