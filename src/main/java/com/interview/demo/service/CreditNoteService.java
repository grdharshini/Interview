package com.interview.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.dto.BillsDto;
import com.interview.demo.dto.CreditNoteBillResponseDto;
import com.interview.demo.dto.CreditNoteDto;
import com.interview.demo.entity.Bills;
import com.interview.demo.entity.CreditNote;
import com.interview.demo.repository.CreditNoteRepository;

@Service
public class CreditNoteService {

	@Autowired
	CreditNoteRepository creditNoteRepository;

	public CreditNote createCreditNote(CreditNoteDto creditNoteDto) {
		CreditNote creditNote = new CreditNote();
		creditNote.setNoteType(creditNoteDto.getNoteType());
		creditNote.setDestinationPlant(creditNoteDto.getDestinationPlant());
		creditNote.setDescription(creditNoteDto.getDescription());
		creditNote.setPartyName(creditNoteDto.getPartyName());
		creditNote.setNoteDate(creditNoteDto.getNoteDate());
		creditNote.setNoteQuantity(creditNoteDto.getNoteQuantity());
		creditNote.setBillQuantity(creditNoteDto.getBillQuantity());
		creditNote.setTotalTcsPercentage(creditNoteDto.getTotalTcsPercentage());
		creditNote.setCompanyName(creditNoteDto.getCompanyName());
		creditNote.setNoteNumber(creditNoteDto.getNoteNumber());
		creditNote.setBillType(creditNoteDto.getBillType());
		creditNote.setTotalGrossAmount(creditNoteDto.getTotalGrossAmount());
		creditNote.setTotalTcsAmount(creditNoteDto.getTotalTcsAmount());
		List<Bills> bills = new ArrayList<>();
		for (BillsDto billsDto : creditNoteDto.getBills()) {
			Bills bill = new Bills();
			bill.setBillDate(billsDto.getBillDate());
			bill.setBillNumber(billsDto.getBillNumber());
			bills.add(bill);
		}
		creditNote.setBills(bills);
		creditNoteRepository.save(creditNote);
		return creditNote;

	}

	public CreditNote updateCreditNote(UUID id, CreditNote creditNote) {
		CreditNote existingCreditNote = creditNoteRepository.findById(id).orElse(null);
		if (existingCreditNote != null) {
			existingCreditNote.setNoteType(creditNote.getNoteType());
			existingCreditNote.setDestinationPlant(creditNote.getDestinationPlant());
			existingCreditNote.setDescription(creditNote.getDescription());
			existingCreditNote.setPartyName(creditNote.getPartyName());
			existingCreditNote.setNoteDate(creditNote.getNoteDate());
			existingCreditNote.setNoteQuantity(creditNote.getNoteQuantity());
			existingCreditNote.setBillQuantity(creditNote.getBillQuantity());
			existingCreditNote.setTotalTcsPercentage(creditNote.getTotalTcsPercentage());
			existingCreditNote.setCompanyName(creditNote.getCompanyName());
			existingCreditNote.setNoteNumber(creditNote.getNoteNumber());
			existingCreditNote.setBillType(creditNote.getBillType());
			existingCreditNote.setTotalGrossAmount(creditNote.getTotalGrossAmount());
			existingCreditNote.setTotalTcsAmount(creditNote.getTotalTcsAmount());
			List<Bills> updatedBills = new ArrayList<>();
			for (Bills bill : creditNote.getBills()) {
				if (bill.getId() != null) {
					Bills existingBill = findExistingBill(existingCreditNote, bill.getId());
					if (existingBill != null) {
						existingBill.setBillNumber(bill.getBillNumber());
						existingBill.setBillDate(bill.getBillDate());
						updatedBills.add(existingBill);
					}
				} else {
					updatedBills.add(bill);
				}
			}
			existingCreditNote.setBills(updatedBills);
			return creditNoteRepository.save(existingCreditNote);
		}
		return existingCreditNote;
	}

	private Bills findExistingBill(CreditNote creditNote, UUID billId) {
		for (Bills bill : creditNote.getBills()) {
			if (bill.getId() != null && bill.getId().equals(billId)) {
				return bill;
			}
		}
		return null;
	}

	public void deleteById(UUID id) {
		creditNoteRepository.deleteById(id);

	}

	public Optional<CreditNote> findById(UUID id) {
		return creditNoteRepository.findById(id);
	}

	public List<CreditNoteBillResponseDto> filterCreditNote(String billNumber) {
		return creditNoteRepository.findByCriteria(billNumber);
	}

	public List<CreditNote> findAll() {
		return creditNoteRepository.findAll();
	}
}
