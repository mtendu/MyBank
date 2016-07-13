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
import lombok.ToString;


@Component
@ToString
@Entity
@Table(name="CUSTOMER_DEMOGRAPHICS")
public @Data class CustomerDemographics  {
	
	@Id
	@GeneratedValue
	@Column(name="DEMOGRAPHICS_ID")
	private int demographicsId;
	
	@ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
	@NonNull
	private Customer customerDemographics;
	
	@Enumerated(EnumType.ORDINAL)
	@NonNull
	private AttributeType attributeType;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="SUFFIX")
	private String suffix;
	
	@Column(name="PREFIX")
	private String prefix;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="SSN")
	private String ssn;
	

}
