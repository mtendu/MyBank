package com.mybank.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.mybank.common.constants.TransactionStatus;
import com.mybank.common.constants.TransactionType;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Entity
@Table(name="TRANSACTION_BANK")
@Data
public class Transaction {

	@Id
	@Column(name="TRANSACTION_ID")
	@GeneratedValue
	private Integer transactionId;
	
	@ManyToOne
    @JoinColumn(name="TO_ACCOUNT_ID")
	private Account toAccount;
	
	@ManyToOne
    @JoinColumn(name="FROM_ACCOUNT_ID")
	private Account fromAccount;

	@OneToOne
    @JoinColumn(name="CUSTOMER_ID")
	@NonNull private Customer tranDoer;
	
    @Column(name="TRANSACTION_TYPE")
	@NonNull private TransactionType transactionType;
    	
	@Enumerated(EnumType.ORDINAL) 
	public TransactionType getTransactionType() { 
	    return transactionType; 
	}
	
	@Column(name="DESCRIPTION")
	private String tranDescription;
	
	@Column(name="BALANCE")
	private Double balance;
	
	@Column(name="TRANSACTION_AMOUNT")
	private Double transactionAmount;
	
    @Column(name="TRANSACTION_STATUS")
	private TransactionStatus transactionStatus = TransactionStatus.STARTED;
	
	@Enumerated(EnumType.STRING) 
	public TransactionStatus getTransactionStatus() { 
	    return transactionStatus; 
	}

}
