package com.interview.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "credit_note")
public class CreditNote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "id")
	private UUID id;
	@Column(name = "note_type")
	private String noteType;
	@Column(name = "destination_plant")
	private String destinationPlant;
	@Column(name = "description")
	private String description;
	@Column(name = "party_name")
	private String partyName;
	@Column(name = "note_date")
	private Date noteDate;
	@Column(name = "note_quantity")
	private int noteQuantity;
	@Column(name = "bill_quantity")
	private String billQuantity;
	@Column(name = "total_tcs_percent")
	private String totalTcsPercentage;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "note_number")
	private String noteNumber;
	@Column(name = "bill_type")
	private String billType;
	@Column(name = "total_gross_amount")
	private double totalGrossAmount;
	@Column(name = "total_tcs_amount")
	private double totalTcsAmount;
	@OneToMany(targetEntity = Bills.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "credit_note_id", referencedColumnName = "id")
	private List<Bills> bills;

}
