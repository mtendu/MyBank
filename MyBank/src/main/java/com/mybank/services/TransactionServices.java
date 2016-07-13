package com.mybank.services;

import com.mybank.common.constants.TransactionType;
import com.mybank.pojo.Account;
import com.mybank.pojo.Check;
import com.mybank.pojo.Customer;
import com.mybank.pojo.Transaction;

public interface TransactionServices {
	
	public Transaction createTransaction(Account account, Customer initiator, TransactionType type);
	public void transfer(Account toAccount, Account fromAccount, Customer initiator, double amount);
	public Transaction withdrawByCash(Account account, Customer initiator, double amount);
	public Transaction depositByCash(Account account, Customer initiator, double amount);
	public Transaction withdrawByCheck(Account account, Customer initiator, Check check);
	public Transaction depositByCheck(Account account, Customer initiator, Check check);

}
