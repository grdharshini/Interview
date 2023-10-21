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

import com.interview.demo.dto.BinWiseSummaryDto;
import com.interview.demo.entity.BinWiseSummary;
import com.interview.demo.service.BinWiseSummaryService;

@RestController
@RequestMapping("/api/binwise-summary")
public class BinWiseSummaryController {

	@Autowired
	BinWiseSummaryService binWiseSummaryService;

	@PostMapping
	public BinWiseSummary createBinWiseSummary(@RequestBody BinWiseSummaryDto binWiseSummaryDto) {
		return binWiseSummaryService.createBinWiseSummary(binWiseSummaryDto);
	}

	@PutMapping("/updateBinWiseSummary/{id}")
	public BinWiseSummary updateBinWiseSummary(@PathVariable UUID id, @RequestBody BinWiseSummary binWiseSummary) {
		return binWiseSummaryService.updateBinWiseSummary(id, binWiseSummary);
	}

	@DeleteMapping("/deleteBinwise/{id}")
	public void deleteBinwise(@PathVariable UUID id) {
		binWiseSummaryService.deleteById(id);
	}

	@GetMapping("{id}")
	public Optional<BinWiseSummary> getBinwiseById(@PathVariable UUID id) {
		return binWiseSummaryService.findById(id);
	}

	@GetMapping("/filterBinWiseSummary")
	public List<BinWiseSummary> filterBinWiseSummary(
			@RequestParam(name = "department", required = false) String department,
			@RequestParam(name = "plant", required = false) String plant,
			@RequestParam(name = "reportType", required = false) String reportType,
			@RequestParam(name = "productType", required = false) String productType,
			@RequestParam(name = "inventoryType", required = false) String inventoryType) {
		return binWiseSummaryService.filterBinWiseSummary(department, plant, reportType, productType, inventoryType);
	}

}
