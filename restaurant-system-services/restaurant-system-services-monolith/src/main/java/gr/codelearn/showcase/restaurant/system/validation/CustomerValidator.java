package gr.codelearn.showcase.restaurant.system.validation;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import gr.codelearn.showcase.restaurant.system.exception.RejectedOperationException;
import gr.codelearn.showcase.restaurant.system.exception.ResourceNotFoundException;
import gr.codelearn.showcase.restaurant.system.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {
	public void ensureCustomerDoesNotExist(final CustomerService customerService, final Customer customer) {
		if (customer == null) {
			throw new RejectedOperationException("You cannot perform this operation as provided customer is empty.");
		}

		if (customer.getId() != null) {
			throw new RejectedOperationException("New customers cannot have an id assigned.");
		}

		if (customer.getEmail() != null) {
			try {
				customerService.findByEmail(customer.getEmail());
				throw new RejectedOperationException("There's an existing customer with the given email.");
			} catch (ResourceNotFoundException _) {
			}
		}
		if (customer.getPhone() != null) {
			customerService.findByPhone(customer.getPhone());
			throw new RejectedOperationException("There's an existing customer with the given phone.");
		}
	}
}
