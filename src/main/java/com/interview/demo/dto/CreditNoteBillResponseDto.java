package com.interview.demo.dto;

import java.util.Date;
import java.util.UUID;

public interface CreditNoteBillResponseDto {

	public UUID getCreditNoteId();

	public String getNoteType();

	public String getDestinationPlant();

	public String getDescription();

	public String getPartyName();

	public Date getNoteDate();

	public Integer getNoteQuantity();

	public String getBillQuantity();

	public String getTotalTcsPercentage();

	public String getCompanyName();

	public String getNoteNumber();

	public String getBillType();

	public Double getTotalGrossAmount();

	public Double getTotalTcsAmount();

	public UUID getBillId();

	public Date getBillDate();

	public String getBillNumber();
}
