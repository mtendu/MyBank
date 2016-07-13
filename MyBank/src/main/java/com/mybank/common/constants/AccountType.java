package com.mybank.common.constants;

public enum AccountType {
	
	SAVINGS_ACCOUNT (1),
	CHECKING_ACCOUNT(20),
	MONET_MARKET_ACCOUNT(3),
	CD_ACCOUNT(4);
	
	private final int accountType;

    private AccountType(int accountType) {
        this.accountType = accountType;
    }

	public int getAccountType() {
		return accountType;
	}

}
