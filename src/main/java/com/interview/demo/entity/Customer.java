package com.interview.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "customer")
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "id")
	private UUID id;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_no")
	private String phoneNo;
//	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer_id", referencedColumnName ="id")
//   private List<Order> orders = new ArrayList<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Order> orders;

}
