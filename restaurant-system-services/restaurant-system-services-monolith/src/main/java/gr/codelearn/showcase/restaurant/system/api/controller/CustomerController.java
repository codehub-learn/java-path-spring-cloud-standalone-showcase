package gr.codelearn.showcase.restaurant.system.api.controller;

import gr.codelearn.showcase.restaurant.system.api.mapper.CustomerMapper;
import gr.codelearn.showcase.restaurant.system.api.resource.CustomerResource;
import gr.codelearn.showcase.restaurant.system.domain.Customer;
import gr.codelearn.showcase.restaurant.system.exception.ContentException;
import gr.codelearn.showcase.restaurant.system.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;
	private final CustomerMapper customerMapper;

	public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
		this.customerService = customerService;
		this.customerMapper = customerMapper;
	}

	@GetMapping
	public List<CustomerResource> all() {
		return customerMapper.toResources(customerService.findAll());
	}

	@PostMapping
	public CustomerResource create(@RequestBody CustomerResource customerResource) {
		//TODO Business-wise
		Customer customer = null;
		try {
			customer = customerService.findByNameAndEmail(customerResource.name(), customerResource.email());
		} catch (ContentException e) {
			customer = customerService.create(customerMapper.toDomain(customerResource));
		}

		return customerMapper.toResource(customer);
	}
}