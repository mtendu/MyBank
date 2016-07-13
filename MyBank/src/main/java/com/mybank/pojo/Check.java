package com.mybank.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Entity
@RequiredArgsConstructor
@Table(name="CHECK")
public @Data class Check {
	
	@Id
	@GeneratedValue
	@Column(name="CHECK_ID")
	private int checkId;
	
	@Column(name="CHECK_NUMBER")
	@NonNull
	private int checkNumber;
	
	@Column(name="CHECK_DATE")
	@NonNull
	private Date checkDate;
	
	@Column(name="PAYEE_NAME")
	@NonNull
	private String payeeName;
	
	@Column(name="CHECK_AMOUNT")
	@NonNull
	private double checkAmount;
	
	

}
