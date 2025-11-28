package gr.codelearn.showcase.restaurant.system.domain;

import gr.codelearn.showcase.restaurant.commons.domain.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "customers",
	   uniqueConstraints = {
			   @UniqueConstraint(name = "uc_email", columnNames = {"email"}),
			   @UniqueConstraint(name = "uc_phone", columnNames = {"phone"})
	   },
	   indexes = {
			   @Index(name = "idx_customer_email", columnList = "email"),
			   @Index(name = "idx_customer_phone", columnList = "phone")
	   })

public class Customer extends BaseModel {
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 20)
	private String phone;
	@Column(nullable = false, length = 50)
	private String email;
}

