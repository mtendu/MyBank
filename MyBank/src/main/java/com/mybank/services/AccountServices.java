package com.mybank.services;

import java.util.Set;

import com.mybank.common.constants.AccountType;
import com.mybank.pojo.Account;
import com.mybank.pojo.Customer;
import com.mybank.pojo.Transaction;

public interface AccountServices {
	
	public Account addAccount(Integer accountNumber, Set<Customer> accountHolders, 
			Integer routingNumber, AccountType type, 
			Double interestRate, Double negativeRate);
	public boolean closeAccount(Account account);
	public boolean lockAccount(Account account);
	public double creditAmount(Transaction transaction);
	public double debitAmount(Transaction transaction);
	public boolean isNegativeBalance(Account account);
	public void addAutorizedUsers(Account account, Customer initiator, Set<Customer> autorizedUsers);
	public void addInterest(Account account);
	public double getBalance(Account account);
	
}
