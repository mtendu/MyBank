package com.mybank.common.constants;

public enum PhoneAvalTime {
	
	MORNING ("morning"),
	AFTERNOON ("afternoon"),
	EVENING ("evening"),
	NIGHT ("night");
	
	private final String avalTime;

    private PhoneAvalTime(String avalTime) {
        this.avalTime = avalTime;
    }

}
