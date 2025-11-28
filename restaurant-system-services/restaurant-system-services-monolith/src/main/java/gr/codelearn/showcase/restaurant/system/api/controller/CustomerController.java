package gr.codelearn.showcase.restaurant.system.api.controller;

import gr.codelearn.showcase.restaurant.commons.api.resource.CustomerResource;
import gr.codelearn.showcase.restaurant.system.api.mapper.CustomerMapper;
import gr.codelearn.showcase.restaurant.system.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerServiceImpl customerService;
	private final CustomerMapper customerMapper;

	@GetMapping
	public List<CustomerResource> all() {
		return customerMapper.toResources(customerService.findAll());
	}

	@PostMapping
	public CustomerResource create(@RequestBody @Valid CustomerResource customerResource) {
		return customerMapper.toResource(customerService.create(customerMapper.toDomain(customerResource)));
	}
}