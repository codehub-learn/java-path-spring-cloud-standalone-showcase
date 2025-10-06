package gr.codelearn.showcase.restaurant.system.repository;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
