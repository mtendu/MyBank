package com.mybank.common.constants;

public enum DataStatus {
	
	ACTIVE (1),
	INACTIVE (2),
	DELETED (3);
	
	private final int status;

    private DataStatus(int status) {
        this.status = status;
    }

}
