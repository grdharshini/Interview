package com.interview.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Order createOrder(Order order) {
		Customer customer = customerRepository.findById(order.getId()).orElse(null);
		if (customer == null) {
			return null;
		}

		Order newOrder = new Order();
		newOrder.setOrderDate(order.getOrderDate());
		newOrder.setShippingAddress(order.getShippingAddress());
		newOrder.setTotalAmount(order.getTotalAmount());
//		newOrder.setCustomer(customer);
//		List<OrderItems> orderItems = new ArrayList<>();
//		for (OrderItems orderItem : order.getOrderItems()) {
//			orderItem.setProduct(orderItem.getProduct());
//			orderItem.setPrice(orderItem.getPrice());
//			orderItem.setQuantity(orderItem.getQuantity());
//			orderItem.setOrder(newOrder);
//			orderItems.add(orderItem);
//		}
//
//		newOrder.setOrderItems(orderItems);

		return orderRepository.save(newOrder);
	}

	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
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

}
