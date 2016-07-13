package com.mybank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mybank.common.constants.TransactionStatus;
import com.mybank.common.constants.TransactionType;
import com.mybank.pojo.Account;
import com.mybank.pojo.Check;
import com.mybank.pojo.Customer;
import com.mybank.pojo.Transaction;
import com.mybank.services.AccountServices;
import com.mybank.services.CheckServices;
import com.mybank.services.TransactionServices;

public class TransactionServicesImpl implements TransactionServices{
	
	@Autowired
	AccountServices accountServices;

	@Override
	public void transfer(Account toAccount, Account fromAccount, Customer initiator, double amount) {
		Transaction withdrawTransaction = new Transaction(initiator, TransactionType.TRANSFER_MONEY_DEBIT);
		withdrawTransaction.setFromAccount(fromAccount);
		
		Transaction depositTransaction = new Transaction(initiator, TransactionType.TRANSFER_MONEY_DEBIT);
		depositTransaction.setToAccount(toAccount);
	
		if(amount <= 0){
			System.err.println("Amount should be greater than zero");
		}

		withdrawTransaction.setTransactionStatus(TransactionStatus.PENDING);
		depositTransaction.setTransactionStatus(TransactionStatus.PENDING);
		
		accountServices.debitAmount(withdrawTransaction);
		accountServices.creditAmount(depositTransaction);
		
		withdrawTransaction.setTransactionStatus(TransactionStatus.COMPLETED);
		depositTransaction.setTransactionStatus(TransactionStatus.COMPLETED);
		System.out.println("Money transfer suceessfully");
	}

	@Override
	public Transaction createTransaction(Account account, Customer initiator, TransactionType type) {
		// TODO Auto-generated method stub
		return new Transaction(initiator, type);
	}

	@Override
	public Transaction withdrawByCash(Account account, Customer initiator, double amount) {
		if(amount > account.getAvailableBalance()){
			System.err.println("Insufficient balance");
		}
	   Transaction 	withdrawByCash = new Transaction(initiator, TransactionType.WITHDRAW_CASH_AMOUNT);
	   withdrawByCash.setTransactionStatus(TransactionStatus.PENDING);
	   withdrawByCash.setFromAccount(account);
	   account.setAvailableBalance(account.getAvailableBalance()- amount);
	   account.setCurrentBalance(account.getAvailableBalance());
	   withdrawByCash.setTransactionAmount(amount);
	   withdrawByCash.setTranDescription("Withdraw by cash");
	   withdrawByCash.setTransactionStatus(TransactionStatus.COMPLETED);
	   
	   System.out.println("Money withdrawed successfully");
	   
	   return withdrawByCash;
			
	}

	@Override
	public  Transaction depositByCash(Account account, Customer initiator, double amount) {
		if(amount <= 0){
			System.err.println("Amount should be greater than zero");
		}
	   Transaction 	depositByCash = new Transaction(initiator, TransactionType.DEPOSIT_CASH_AMOUNT);
	   depositByCash.setTransactionStatus(TransactionStatus.PENDING);
	   depositByCash.setToAccount(account);
	   account.setAvailableBalance(account.getAvailableBalance()+ amount);
	   account.setCurrentBalance(account.getAvailableBalance());
	   depositByCash.setTransactionAmount(amount);
	   depositByCash.setTranDescription("Deposit by cash");
	   depositByCash.setTransactionStatus(TransactionStatus.COMPLETED);
	   
	   System.out.println("Money deposited successfully");
	   
	   return depositByCash;
		
	}

	@Override
	public Transaction withdrawByCheck(Account account, Customer initiator, Check check) {
		CheckServices checkServices = new CheckServicesImpl();
		if(checkServices.verifyCheckNumber(check)== false || checkServices.verifyDate(check) == false){
			System.err.println("Check is invalid");
		}
		if(check.getCheckAmount() <= 0){
			System.err.println("Amount should be greater than zero");
		}
	   Transaction 	withdrawByCheck = new Transaction(initiator, TransactionType.WITHDRAW_CHECK_AMOUNT);
	   withdrawByCheck.setTransactionStatus(TransactionStatus.PENDING);
	   
	   withdrawByCheck.setToAccount(account);
	   withdrawByCheck.setTranDoer(initiator);
	   
	   account.setAvailableBalance(account.getAvailableBalance() - check.getCheckAmount());
	   account.setCurrentBalance(account.getAvailableBalance());
	   
	   withdrawByCheck.setTransactionAmount(check.getCheckAmount());
	   withdrawByCheck.setTranDescription("Withdraw by check");
	   withdrawByCheck.setTransactionStatus(TransactionStatus.COMPLETED);
	   
	   System.out.println("Money deposited successfully");
	   
	   return withdrawByCheck;
	
		
	}

	@Override
	public Transaction depositByCheck(Account account, Customer initiator, Check check) {
		CheckServices checkServices = new CheckServicesImpl();
		if(checkServices.verifyCheckNumber(check)== false || checkServices.verifyDate(check) == false){
			System.err.println("Check is invalid");
		}
		if(check.getCheckAmount() <= 0){
			System.err.println("Amount should be greater than zero");
		}
	   Transaction 	depositByCheck = new Transaction(initiator, TransactionType.DEPOSIT_CHECK_AMOUNT);
	   depositByCheck.setTransactionStatus(TransactionStatus.PENDING);
	   
	   depositByCheck.setToAccount(account);
	   depositByCheck.setTranDoer(initiator);
	   
	   account.setAvailableBalance(account.getAvailableBalance()+ check.getCheckAmount());
	   account.setCurrentBalance(account.getAvailableBalance());
	   
	   depositByCheck.setTransactionAmount(check.getCheckAmount());
	   depositByCheck.setTranDescription("Deposit by check");
	   depositByCheck.setTransactionStatus(TransactionStatus.COMPLETED);
	   
	   System.out.println("Money deposited successfully");
	   
	   return depositByCheck;
		
	}

}
