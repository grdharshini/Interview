package com.interview.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.dto.OrderDto;
import com.interview.demo.dto.OrderItemsDto;
import com.interview.demo.entity.Customer;
import com.interview.demo.entity.Order;
import com.interview.demo.entity.OrderItems;
import com.interview.demo.repository.CustomerRepository;
import com.interview.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	public Order createOrder(OrderDto orderDto) {
		Order order = new Order();
		order.setOrderDate(orderDto.getOrderDate());
		order.setShippingAddress(orderDto.getShippingAddress());
		order.setTotalAmount(orderDto.getTotalAmount());
		return orderRepository.save(order);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order updateOrder(UUID id, Order order) {
		Order existingOrder = orderRepository.findById(id).orElse(null);
		if (existingOrder != null) {
			existingOrder.setOrderDate(order.getOrderDate());
			existingOrder.setShippingAddress(order.getShippingAddress());
			existingOrder.setTotalAmount(order.getTotalAmount());
			return orderRepository.save(existingOrder);
		}
		return existingOrder;
	}

	public List<Order> getOrdersForCustomer(Customer customer) {
		return orderRepository.findAll();
	}

}
