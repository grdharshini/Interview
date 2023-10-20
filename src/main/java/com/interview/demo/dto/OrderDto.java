package com.interview.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.interview.demo.entity.Customer;

import lombok.Data;

@Data
public class OrderDto {
	private UUID id;

	private Date orderDate;

	private String shippingAddress;

	private double totalAmount;

	private Customer customer;

	private List<OrderItemsDto> orderItems = new ArrayList<>();
}
