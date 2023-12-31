package com.interview.demo.controller;

import java.util.ArrayList;
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
import com.interview.demo.dto.OrderDto;
import com.interview.demo.dto.OrderItemsDto;
import com.interview.demo.entity.Customer;
import com.interview.demo.entity.Order;
import com.interview.demo.entity.OrderItems;
import com.interview.demo.service.CustomerService;
import com.interview.demo.service.OrderItemsService;
import com.interview.demo.service.OrderService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderItemsService orderItemService;

	@PostMapping
	public Customer createCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);
	}

//
//	@GetMapping("/getAllCustomers")
//	public List<CustomerDto> getAllCustomers() {
//		List<Customer> customers = customerService.getAllCustomers();
//		List<CustomerDto> custometDTOs = customers.stream().map(customer -> {
//			CustomerDto dto = new CustomerDto();
//			dto.setAddress(customer.getAddress());
//			dto.setCustomerName(customer.getCustomerName());
//			dto.setEmail(customer.getEmail());
//			dto.setPhoneNo(customer.getPhoneNo());
//			List<Order> orders = orderService.getOrdersForCustomer(customer);
//			
//			return dto;
//		}).collect(Collectors.toList());
//
//		return custometDTOs;
//	}
	@GetMapping("/getAllCustomers")
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		List<CustomerDto> customerDTOs = new ArrayList<>();

		for (Customer customer : customers) {
			CustomerDto dto = new CustomerDto();
			dto.setId(customer.getId());
			dto.setAddress(customer.getAddress());
			dto.setCustomerName(customer.getCustomerName());
			dto.setEmail(customer.getEmail());
			dto.setPhoneNo(customer.getPhoneNo());

			List<Order> orders = orderService.getOrdersForCustomer(customer);

			List<OrderDto> orderDTOs = orders.stream().map(order -> {
				OrderDto orderDto = new OrderDto();
				orderDto.setId(order.getId());
				orderDto.setOrderDate(order.getOrderDate());
				orderDto.setShippingAddress(order.getShippingAddress());
				orderDto.setTotalAmount(order.getTotalAmount());

				List<OrderItems> orderItems = orderItemService.getOrderItemsForOrder(order);

				List<OrderItemsDto> orderItemDTOs = orderItems.stream().map(orderItem -> {
					OrderItemsDto orderItemDto = new OrderItemsDto();
					orderItemDto.setId(orderItem.getId());
					orderItemDto.setPrice(orderItem.getPrice());
					orderItemDto.setProduct(orderItem.getProduct());
					orderItemDto.setQuantity(orderItem.getQuantity());
					return orderItemDto;
				}).collect(Collectors.toList());

				orderDto.setOrderItems(orderItemDTOs);
				return orderDto;
			}).collect(Collectors.toList());

			dto.setOrders(orderDTOs);
			customerDTOs.add(dto);
		}

		return customerDTOs;
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
