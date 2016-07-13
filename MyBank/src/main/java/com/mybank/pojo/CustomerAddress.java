package com.mybank.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.mybank.common.constants.AttributeType;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Entity
@RequiredArgsConstructor
@Table(name="CUSTOMER_ADDRESS")
public @Data class CustomerAddress {
	
	@Id
	@GeneratedValue
	@Column(name="ADDRESS_ID")
	private int addressId;
	
	@ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
	@NonNull
	private Customer customerAddress;
	
	@Enumerated(EnumType.STRING) 
	@NonNull
	private AttributeType attributeType;
	
	@Column(name="STLINE1")
	private String stLine1;
	
	@Column(name="STLINE2")
	private String stLine2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIPCODE")
	private String zipCode;
	

}
