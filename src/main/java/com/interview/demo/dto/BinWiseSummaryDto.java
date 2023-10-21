package com.interview.demo.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class BinWiseSummaryDto {
	private UUID id;
	private String binName;
	private String binCardNo;
	private String productName;
	private String productCategory;
	private String lot;
	private int stockQuantity;
	private double averageCost;
	private double cost;
	private String department;
	private String plant;
	private String reportType;
	private String productType;
	private String inventoryType;

}
