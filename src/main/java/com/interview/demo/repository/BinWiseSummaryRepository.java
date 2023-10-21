package com.interview.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.interview.demo.entity.BinWiseSummary;

@Repository
public interface BinWiseSummaryRepository extends JpaRepository<BinWiseSummary, UUID> {

	@Query(value = "SELECT b.id as id, b.bin_name as binName, b.bin_card_no as binCardNo, b.product_name as productName, "
			+ "b.product_category as productCategory, b.lot as lot, b.stock_quantity as stockQuantity, "
			+ "b.average_cost as averageCost, b.cost as cost, b.department as department, b.plant as plant, "
			+ "b.product_type as productType, b.report_type as reportType, b.inventory_type as inventoryType "
			+ "FROM bin_wise_summary b " + "WHERE (:department IS NULL OR b.department = :department) "
			+ "AND (:plant IS NULL OR b.plant = :plant) " + "AND (:reportType IS NULL OR b.report_type = :reportType) "
			+ "AND (:productType IS NULL OR b.product_type = :productType) "
			+ "AND (:inventoryType IS NULL OR b.inventory_type = :inventoryType) ", nativeQuery = true)
	List<BinWiseSummary> findByCriteria(String department, String plant, String reportType, String productType,
			String inventoryType);

}
