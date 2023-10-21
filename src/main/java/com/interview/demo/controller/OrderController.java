package com.interview.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.dto.OrderDto;
import com.interview.demo.entity.Order;
import com.interview.demo.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@PostMapping
	public Order createOrder(@RequestBody OrderDto orderDto) {
		return orderService.createOrder(orderDto);
	}

	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@PutMapping("/updateOrder/{id}")
	public Order updateOrder(@PathVariable UUID id, @RequestBody Order order) {
		return orderService.updateOrder(id, order);
	}

}
