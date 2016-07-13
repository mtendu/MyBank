package com.mybank.pojo;

import java.util.Date;

import com.mybank.common.constants.DataStatus;

import lombok.Data;

public @Data class BaseTableObject {
	
	private Date dateCreated;
	private Date dateUpdated;
	private DataStatus dataStatus;

}
