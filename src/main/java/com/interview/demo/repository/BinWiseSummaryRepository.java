package com.interview.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.interview.demo.entity.BinWiseSummary;

@Repository
public interface BinWiseSummaryRepository extends JpaRepository<BinWiseSummary, UUID> {

	@Query("SELECT b FROM BinWiseSummary b " + "WHERE (:departmentParam IS NULL OR b.department = :departmentParam) "
			+ "AND (:plantParam IS NULL OR b.plant = :plantParam) "
			+ "AND (:reportTypeParam IS NULL OR b.reportType = :reportTypeParam) "
			+ "AND (:productTypeParam IS NULL OR b.productType = :productTypeParam) "
			+ "AND (:inventoryTypeParam IS NULL OR b.inventoryType = :inventoryTypeParam)")
	List<BinWiseSummary> findByCriteria(@Param("departmentParam") String department, @Param("plantParam") String plant,
			@Param("reportTypeParam") String reportType, @Param("productTypeParam") String productType,
			@Param("inventoryTypeParam") String inventoryType);

}
