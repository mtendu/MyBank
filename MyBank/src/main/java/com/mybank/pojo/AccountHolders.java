package com.mybank.pojo;

import java.util.Set;

import lombok.Data;

@Data
public class AccountHolders {
	
	private Account account;
	
	private Set<Customer> authorizedUsers;

}
