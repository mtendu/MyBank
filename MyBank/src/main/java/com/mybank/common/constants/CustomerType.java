package com.mybank.common.constants;

public enum CustomerType {
	
	ACCOUNT_HOLDER (1),
	AUTH_USER (2);
	
	private final int customerType;

    private CustomerType(int customerType) {
        this.customerType = customerType;
    }

}
