package com.interview.demo.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class CreditNoteDto {
	private UUID id;
	private String noteType;
	private String destinationPlant;
	private String description;
	private String partyName;
	private Date noteDate;
	private int noteQuantity;
	private String billQuantity;
	private String totalTcsPercentage;
	private String companyName;
	private String noteNumber;
	private String billType;
	private double totalGrossAmount;
	private double totalTcsAmount;
	private List<BillsDto> bills;
}
