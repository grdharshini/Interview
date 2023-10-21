package com.interview.demo.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@Table(name = "binwise_summary")
public class BinWiseSummary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "id")
	private UUID id;
	@Column(name = "bin_name")
	private String binName;
	@Column(name = "bincard_no")
	private String binCardNo;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_category")
	private String productCategory;
	@Column(name = "lot")
	private String lot;
	@Column(name = "stock_quantity")
	private int stockQuantity;
	@Column(name = "average_cost")
	private double averageCost;
	@Column(name = "cost")
	private double cost;
	@Column(name = "department")
	private String department;
	@Column(name = "plant")
	private String plant;
	@Column(name = "report_type")
	private String reportType;
	@Column(name = "product_type")
	private String productType;
	@Column(name = "inventory_type")
	private String inventoryType;
}
