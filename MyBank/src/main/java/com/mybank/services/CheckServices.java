package com.mybank.services;

import com.mybank.pojo.Check;

public interface CheckServices {
	
	public boolean verifyCheckNumber(Check check);
	public boolean verifyDate(Check check);
	

}
