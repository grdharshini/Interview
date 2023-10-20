package com.interview.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class CustomerDto {
	
	private UUID id;
	private String customerName;
	
	private String email;
	
	private String address;
	
	private String phoneNo;
	
    private List<OrderDto> orders = new ArrayList<>();

}
