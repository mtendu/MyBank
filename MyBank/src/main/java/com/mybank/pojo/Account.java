package com.mybank.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.mybank.common.constants.AccountType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;  

@Component
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ACCOUNT")
public @Data class Account {

	@Id @Setter(AccessLevel.PRIVATE) 
	@Column(name="ACCOUNT_ID")
	@GeneratedValue
	private Integer accountId;
	
	@Setter(AccessLevel.PRIVATE) @NonNull 
	@Column(name="ACCOUNT_NUMBER")
	private Integer accountNumber;
	
	@Column(name="ROUTING_NUMBER")
	@Setter(AccessLevel.PRIVATE) @NonNull 
	private Integer routingNumber;
	
	@Column(name="CURRENT_BALANCE") @NonNull 
	private Double currentBalance;
	
	@Column(name="AVAILABLE_BALANCE") @NonNull 
	private Double availableBalance;
	
	@Column(name="ACCOUNT_TYPE")
	@Setter(AccessLevel.PRIVATE) 
	@NonNull 
	@Enumerated(EnumType.ORDINAL) 
	private AccountType accountType;
	
	
	public AccountType getAccountType() { 
	    return accountType; 
	}
	
	@Column(name="DATE_CREATED")
	@Setter(AccessLevel.PRIVATE) @NonNull 
	private Date dateCreated;
	
	@Column(name="INTEREST_RATE")
	@Setter(AccessLevel.PRIVATE) @NonNull 
	private Double interestRate;
	
	@Column(name="NEGATIVE_INTEREST_RATE")
	@Setter(AccessLevel.PRIVATE) @NonNull 
	private Double negativeRate;
	
	@Column(name="CLOSED_FLAG")
	private Boolean isClosed;
	
	@Column(name="LOCKED_FLAG")
	private Boolean isLocked;
	
	//@OneToMany(mappedBy="accountHolderCustomer", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@ManyToMany
	@JoinTable(
			name = "ACCOUNT_CUSTOMER",
			joinColumns = @JoinColumn(name="ACCOUNT_ID"),
			inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
	private Set<Customer> accountHolders;
	
	@ManyToMany
	@JoinTable(
			name = "ACCOUNT_AUTHORIZEDUSERS",
			joinColumns = @JoinColumn(name="ACCOUNT_ID"),
			inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
	private Set<Customer> authorizedUsers;
    
	@OneToMany(mappedBy="toAccount", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Transaction> toAccountTransactions;
    
    @OneToMany(mappedBy="fromAccount", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Transaction> fromAccountTransactions; 

}
