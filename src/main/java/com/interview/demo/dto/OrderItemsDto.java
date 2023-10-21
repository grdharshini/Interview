package com.interview.demo.dto;

import java.util.UUID;

import com.interview.demo.entity.Order;

import lombok.Data;

@Data
public class OrderItemsDto {

	private UUID id;
	private String product;
	private double price;
	private int quantity;
}
