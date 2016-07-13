package com.mybank.common.constants;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

public enum TransactionType {
	
	WITHDRAW_CASH_AMOUNT (1),
	DEPOSIT_CASH_AMOUNT (2),
	WITHDRAW_CHECK_AMOUNT (3),
	DEPOSIT_CHECK_AMOUNT (4),
	WITHDRAW_CREDIT_AMOUNT (5),
	PAY_CREDIT_AMOUNT (6),
	OPEN_ACCOUNT (7),
	CLOSE_ACCOUNT (8),
	LOCK_ACCOUNT (9),
	TRANSFER_MONEY_CREDIT (10),
	TRANSFER_MONEY_DEBIT (11),
	ADD_AUTH_USER (12)
	;
	
	private final int transactionType;

    private TransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

}
