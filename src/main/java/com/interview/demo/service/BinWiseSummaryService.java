package com.interview.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.dto.BinWiseSummaryDto;
import com.interview.demo.entity.BinWiseSummary;
import com.interview.demo.repository.BinWiseSummaryRepository;

@Service
public class BinWiseSummaryService {

	@Autowired
	BinWiseSummaryRepository binWiseSummaryRepository;

	public BinWiseSummary createBinWiseSummary(BinWiseSummaryDto binWiseSummaryDto) {
		BinWiseSummary binWiseSummary = new BinWiseSummary();
		binWiseSummary.setBinName(binWiseSummaryDto.getBinName());
		binWiseSummary.setBinCardNo(binWiseSummaryDto.getBinCardNo());
		binWiseSummary.setProductName(binWiseSummaryDto.getProductName());
		binWiseSummary.setProductCategory(binWiseSummaryDto.getProductCategory());
		binWiseSummary.setLot(binWiseSummaryDto.getLot());
		binWiseSummary.setStockQuantity(binWiseSummaryDto.getStockQuantity());
		binWiseSummary.setAverageCost(binWiseSummaryDto.getAverageCost());
		binWiseSummary.setCost(binWiseSummaryDto.getCost());
		binWiseSummary.setDepartment(binWiseSummaryDto.getDepartment());
		binWiseSummary.setPlant(binWiseSummaryDto.getPlant());
		binWiseSummary.setProductType(binWiseSummaryDto.getProductType());
		binWiseSummary.setReportType(binWiseSummaryDto.getReportType());
		binWiseSummary.setInventoryType(binWiseSummaryDto.getInventoryType());
		return binWiseSummaryRepository.save(binWiseSummary);
	}

	public BinWiseSummary updateBinWiseSummary(UUID id, BinWiseSummary binWiseSummary) {
		BinWiseSummary existingBinwise = binWiseSummaryRepository.findById(id).orElse(null);
		if (existingBinwise != null) {
			existingBinwise.setBinName(binWiseSummary.getBinName());
			existingBinwise.setBinCardNo(binWiseSummary.getBinCardNo());
			existingBinwise.setProductName(binWiseSummary.getProductName());
			existingBinwise.setProductCategory(binWiseSummary.getProductCategory());
			existingBinwise.setLot(binWiseSummary.getLot());
			existingBinwise.setStockQuantity(binWiseSummary.getStockQuantity());
			existingBinwise.setAverageCost(binWiseSummary.getAverageCost());
			existingBinwise.setCost(binWiseSummary.getCost());
			existingBinwise.setDepartment(binWiseSummary.getDepartment());
			existingBinwise.setPlant(binWiseSummary.getPlant());
			existingBinwise.setProductType(binWiseSummary.getProductType());
			existingBinwise.setReportType(binWiseSummary.getReportType());
			existingBinwise.setInventoryType(binWiseSummary.getInventoryType());
			return binWiseSummaryRepository.save(existingBinwise);
		}
		return existingBinwise;
	}

	public void deleteById(UUID id) {
		binWiseSummaryRepository.deleteById(id);
	}

	public Optional<BinWiseSummary> findById(UUID id) {
		return binWiseSummaryRepository.findById(id);
	}

	public List<BinWiseSummary> filterBinWiseSummary(String department, String plant, String reportType,
			String productType, String inventoryType) {
		return binWiseSummaryRepository.findByCriteria(department, plant, reportType, productType, inventoryType);
	}

}
