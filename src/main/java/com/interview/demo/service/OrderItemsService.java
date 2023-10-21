package com.interview.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.entity.Order;
import com.interview.demo.entity.OrderItems;
import com.interview.demo.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

	@Autowired
	OrderItemsRepository orderItemsRepository;

	public List<OrderItems> getOrderItemsForOrder(Order order) {
		return orderItemsRepository.findAll();
	}

}
