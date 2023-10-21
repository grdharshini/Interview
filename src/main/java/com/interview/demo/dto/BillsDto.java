package com.interview.demo.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class BillsDto {
	private UUID id;
	private Date billDate;
	private String billNumber;
}
