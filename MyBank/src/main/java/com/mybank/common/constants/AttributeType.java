package com.mybank.common.constants;

public enum AttributeType {
	
	USER_INFO (1),
	ADDRESS_HOME (2),
	ADDRESS_WORK (3),
	PHONE_HOME (4),
	PHONE_CELL (5),
	PHONE_WORK (6),
	FAX_HOME (7),
	FAX_WORK (8);
	
	private final int attributeType;

    private AttributeType(int attributeType) {
        this.attributeType = attributeType;
    }

}
