package com.mybank.services.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybank.common.constants.AccountType;
import com.mybank.common.constants.TransactionType;
import com.mybank.pojo.Account;
import com.mybank.pojo.Customer;
import com.mybank.pojo.Transaction;
import com.mybank.services.AccountServices;
import com.mybank.services.TransactionServices;

@Component
public class AccountServicesImpl implements AccountServices {
	
	@Autowired
	TransactionServices transactionServices;


	public Account addAccount(Integer accountNumber, Set<Customer> accountHolders, 
			Integer routingNumber, AccountType type, 
			Double interestRate, Double negativeRate) {
		
		Account account = new Account(accountNumber, routingNumber, 
				new Double(0), new Double(0), type, new Date(), interestRate, negativeRate);
		Set<Customer> accountHoldersSet = new HashSet<Customer>();
		accountHoldersSet.addAll(accountHolders);
		account.setAccountHolders(accountHoldersSet);
		
		return account;
		
	}

	@Override
	public boolean closeAccount(Account account) {
		account.setIsClosed(true);
		return true;
	}

	@Override
	public double creditAmount(Transaction transaction) {
		Account account  = transaction.getToAccount();
		account.setAvailableBalance(account.getAvailableBalance() + transaction.getTransactionAmount());
		return account.getCurrentBalance();
	}

	@Override
	public double debitAmount(Transaction transaction) {
		Account account  = transaction.getFromAccount();
		account.setAvailableBalance(account.getAvailableBalance() - transaction.getTransactionAmount());
		return account.getCurrentBalance();
	}

	@Override
	public boolean isNegativeBalance(Account account) {
		boolean ret = (account.getAvailableBalance() > new Double(0)) ? true : false;
		return ret;
	}

	@Override
	public void addAutorizedUsers(Account account, Customer initiator, Set<Customer> autorizedUsers) {
		//Transaction transaction = transactionServices.createTransaction(account, initiator, TransactionType.ADD_AUTH_USER);
		Set<Customer> authUsers = new HashSet<Customer>();
		if ((account.getAuthorizedUsers() == null) || (account.getAuthorizedUsers().size() == 0)) {
			authUsers.addAll(autorizedUsers);
			account.setAuthorizedUsers(authUsers);
			return;
		}
		autorizedUsers.forEach((authorizedUser) -> {
			for (Customer curAuthUser : account.getAuthorizedUsers()) {
				if (curAuthUser.equals(authorizedUser)) {
					continue;
				} else {
					account.getAuthorizedUsers().add(authorizedUser);
					break;
				}
			}
		});
		
	}

	public void addAccountHolder(Account account, Set<Customer> accountHolders){
		if((account.getAccountHolders() == null) || (account.getAccountHolders().size() == 0)){
			System.err.println("Account Holder cannot be null or empty");
		}
		
		accountHolders.forEach((accountHolder) -> {
			
			for (Customer curAuthUser : account.getAccountHolders()) {
				if (curAuthUser.equals(accountHolder)) {
					System.err.println("Account Holder already exist");
				} else {
					account.getAccountHolders().add(accountHolder);
					break;
				}
			}
		});
		
	}

	@Override
	public void addInterest(Account account) {
		
		account.setAvailableBalance(account.getAvailableBalance() +
				(account.getAvailableBalance() * account.getInterestRate()));
		
	}

	@Override
	public boolean lockAccount(Account account) {
		account.setIsLocked(true);
		return true;
	}

	@Override
	public double getBalance(Account account) {
		return account.getAvailableBalance();
	}
	

}
