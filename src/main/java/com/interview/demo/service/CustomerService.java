package com.interview.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.dto.CustomerDto;
import com.interview.demo.dto.OrderDto;
import com.interview.demo.entity.Customer;
import com.interview.demo.entity.Order;
import com.interview.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer createCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setAddress(customerDto.getAddress());
		customer.setPhoneNo(customerDto.getPhoneNo());
		List<Order> orders = new ArrayList<>();
		for (OrderDto orderDto : customerDto.getOrders()) {
			Order order = new Order();
			order.setOrderDate(orderDto.getOrderDate());
			order.setShippingAddress(orderDto.getShippingAddress());
			order.setTotalAmount(orderDto.getTotalAmount());
//			List<OrderItems> orderItemsList = new ArrayList<>();
//			for (OrderItemsDto orderItemDto : orderDto.getOrderItems()) {
//				OrderItems orderItem = new OrderItems();
//				orderItem.setProduct(orderItemDto.getProduct());
//				orderItem.setPrice(orderItemDto.getPrice());
//				orderItem.setQuantity(orderItemDto.getQuantity());
//				orderItem.setOrder(order);
//				orderItemsList.add(orderItem);
//			}
//			order.setOrderItems(orderItemsList);
			orders.add(order);
		}
		customer.setOrders(orders);
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer updateCustomer(UUID id, Customer customer) {
		Customer existingCustomer = customerRepository.findById(id).orElse(null);
		if (existingCustomer != null) {
			existingCustomer.setAddress(customer.getAddress());
			existingCustomer.setCustomerName(customer.getCustomerName());
			existingCustomer.setEmail(customer.getEmail());
			return customerRepository.save(existingCustomer);
		}
		return existingCustomer;
	}

	public void deleteById(UUID id) {
		customerRepository.deleteById(id);

	}

	    public List<Customer> filterCustomers(String customerName, String email, String phoneNo) {
	        List<Customer> allCustomers = customerRepository.findAll();

	        Stream<Customer> customerStream = allCustomers.stream();

	        if (customerName != null) {
	            customerStream = customerStream.filter(customer -> customer.getCustomerName().equals(customerName));
	        }

	        if (email != null) {
	            customerStream = customerStream.filter(customer -> customer.getEmail().equals(email));
	        }

	        if (phoneNo != null) {
	            customerStream = customerStream.filter(customer -> customer.getPhoneNo().equals(phoneNo));
	        }

	        return customerStream.collect(Collectors.toList());
	    
	}

}
