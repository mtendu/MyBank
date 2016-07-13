package com.mybank.common.constants;

public enum TransactionStatus {
	
	STARTED (1),
	PENDING (2),
	COMPLETED (3);
	
	private final int status;

    private TransactionStatus(int status) {
        this.status = status;
    }

}
