package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import gr.codelearn.showcase.restaurant.system.exception.RejectedOperationException;
import gr.codelearn.showcase.restaurant.system.exception.ResourceNotFoundException;
import gr.codelearn.showcase.restaurant.system.repository.CustomerRepository;
import gr.codelearn.showcase.restaurant.system.validation.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long> implements CustomerService {
	private final CustomerRepository customerRepository;
	private final CustomerValidator customerValidator;

	@Override
	public JpaRepository<Customer, Long> getRepository() {
		return customerRepository;
	}

	@Override
	public Customer create(final Customer customer) {
		Customer customerSaved = null;
		try {
			customerValidator.ensureCustomerDoesNotExist(this, customer);
		} catch (ResourceNotFoundException e) {
			customerSaved = super.create(customer);
		}

		if (customerSaved == null) {
			throw new RejectedOperationException("Unable to save provided customer '%s'.".formatted(customer));
		}

		return customerSaved;
	}

	public Customer findById(final Long id) {
		return customerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(("Customer #%d was not found").formatted(id)));
	}

	public Customer findByEmail(final String email) {
		return customerRepository.findByEmail(email).orElseThrow(
				() -> new ResourceNotFoundException(("Customer with email %s was not found").formatted(email)));
	}

	public Customer findByPhone(final String phone) {
		return customerRepository.findByPhone(phone).orElseThrow(
				() -> new ResourceNotFoundException(("Customer with phone %s was not found").formatted(phone)));
	}
}
