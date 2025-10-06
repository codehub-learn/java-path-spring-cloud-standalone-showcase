package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import gr.codelearn.showcase.restaurant.system.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	//ΝΟΤΕ
	private final CustomerRepository customers;

	public CustomerService(CustomerRepository customers) {
		this.customers = customers;
	}

	public Customer createCustomer(String name, String phone) {
		Customer c = new Customer();
		c.setName(name);
		c.setPhone(phone);
		return customers.save(c);
	}
}
