package com.interview.demo.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.dto.CustomerDto;
import com.interview.demo.entity.Customer;
import com.interview.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping
	public Customer createCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);
	}

	@GetMapping("/getAllCustomers")
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		List<CustomerDto> custometDTOs = customers.stream().map(customer -> {
			CustomerDto dto = new CustomerDto();
			dto.setAddress(customer.getAddress());
			dto.setCustomerName(customer.getCustomerName());
			dto.setEmail(customer.getEmail());
			dto.setPhoneNo(customer.getPhoneNo());
			return dto;
		}).collect(Collectors.toList());

		return custometDTOs;
	}

	@GetMapping("/filter")
	public List<Customer> filterCustomers(@RequestParam(name = "customerName", required = false) String customerName,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "phoneNo", required = false) String phoneNo) {
		return customerService.filterCustomers(customerName, email, phoneNo);
	}

	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable UUID id) {
		customerService.deleteById(id);
	}
}
