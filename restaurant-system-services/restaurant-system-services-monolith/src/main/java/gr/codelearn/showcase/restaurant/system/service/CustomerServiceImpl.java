package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import gr.codelearn.showcase.restaurant.system.exception.ResourceNotFoundException;
import gr.codelearn.showcase.restaurant.system.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long> implements CustomerService {
	private final CustomerRepository customerRepository;

	@Override
	public JpaRepository<Customer, Long> getRepository() {
		return customerRepository;
	}

	public Customer findById(final Long id) {
		return customerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(("Customer #%d was not found").formatted(id)));
	}

	public Customer findByNameAndEmail(final String name, final String email) {
		return customerRepository.findByNameAndEmail(name, email).orElseThrow(
				() -> new ResourceNotFoundException(("Customer %s (%s) was not found").formatted(name, email)));
	}
}
