package com.interview.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.dto.CreditNoteBillResponseDto;
import com.interview.demo.dto.CreditNoteDto;
import com.interview.demo.entity.CreditNote;
import com.interview.demo.service.CreditNoteService;

@RestController
@RequestMapping("/api/credit-note")
public class CreditNoteController {

	@Autowired
	CreditNoteService creditNoteService;

	@PostMapping
	public CreditNote createCreditNote(@RequestBody CreditNoteDto creditNoteDto) {
		return creditNoteService.createCreditNote(creditNoteDto);
	}

	@PutMapping("/updateCreditNote/{id}")
	public CreditNote updateCreditNote(@PathVariable UUID id, @RequestBody CreditNote creditNote) {
		return creditNoteService.updateCreditNote(id, creditNote);
	}

	@DeleteMapping("/deleteCreditNote/{id}")
	public void deleteCreditNote(@PathVariable UUID id) {
		creditNoteService.deleteById(id);
	}

	@GetMapping("{id}")
	public Optional<CreditNote> getCreateNoteById(@PathVariable UUID id) {
		return creditNoteService.findById(id);
	}

	@GetMapping("/getAllCreditNote")
	public List<CreditNote> getAllCreditNote() {
		return creditNoteService.findAll();
	}

	@GetMapping("/filterCreditNote")
	public List<CreditNoteBillResponseDto> filterCreditNote(
			@RequestParam(name = "billNumber", required = false) String billNumber) {
		return creditNoteService.filterCreditNote(billNumber);
	}

}
