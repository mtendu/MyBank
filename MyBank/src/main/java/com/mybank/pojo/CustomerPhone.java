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
import com.mybank.common.constants.PhoneAvalTime;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Entity
@Table(name="CUSTOMER_PHONE")
public @Data class CustomerPhone  {
	
	@Id
	@GeneratedValue
	@Column(name="PHONE_ID")
	private int phoneID;
	
	@ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
	@NonNull private Customer customerPhone;
	
	@Enumerated(EnumType.ORDINAL)
	@NonNull private AttributeType attributeType;
	
	@Column(name="PHONE_TYPE")
	private String phoneType;
	
	@Column(name="PHONE_AREA")
	private String phoneArea;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="PHONE_EXT")
	private String phoneExt;
	
	@Column(name="PHONE_AVAL_TIME")
	private PhoneAvalTime phoneAvalTimeSet;
	

}
