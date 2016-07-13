package com.mybank.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name="CUSTOMER")
public @Data class Customer {
	
	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue
	private int customerId;
	
	@Column(name="USERNAME") @NonNull
	private String userName;
	
	@Column(name="PASSWORD") @NonNull
	private String password;
	
	@Column(name="LAST_LOGIN")
	private Date lastLogin;
	
	@OneToMany(mappedBy="customerAddress", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<CustomerAddress> customerAddress;
	
	@OneToMany(mappedBy="customerDemographics", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<CustomerDemographics> customerDemographics;
	
	@OneToMany(mappedBy="customerPhone", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<CustomerPhone> customerPhone;

	
	@ManyToMany(mappedBy="accountHolders")
	private Set<Account> accountHolderCustomer;

	
	@ManyToMany(mappedBy="authorizedUsers")
	private Set<Account> accountAuthorizedCustomer;

}
