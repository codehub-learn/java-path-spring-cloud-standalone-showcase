package gr.codelearn.showcase.restaurant.system.repository;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByNameAndEmail(String name, String email);

	Optional<Customer> findByPhone(String phone);
}
