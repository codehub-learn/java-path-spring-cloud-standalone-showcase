package gr.codelearn.showcase.restaurant.system.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "customers")
public class Customer extends BaseModel {
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String phone;
	@Column(nullable = false, length = 50)
	private String email;
}

