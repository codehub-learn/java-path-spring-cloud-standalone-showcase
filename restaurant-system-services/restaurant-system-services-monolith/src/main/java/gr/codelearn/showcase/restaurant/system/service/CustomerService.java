package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.commons.service.BaseService;
import gr.codelearn.showcase.restaurant.system.domain.Customer;

public interface CustomerService extends BaseService<Customer, Long> {
	Customer findById(Long id);

	Customer findByEmail(String email);

	Customer findByPhone(String phone);
}
