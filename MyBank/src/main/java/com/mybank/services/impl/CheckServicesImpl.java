package com.mybank.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mybank.pojo.Check;
import com.mybank.services.CheckServices;

public class CheckServicesImpl implements CheckServices{

	@Override
	public boolean verifyCheckNumber(Check check) {
		int length = (int) Math.log10(check.getCheckNumber()) + 1;
		if(length != 10){
		return false;
		}
		return true;
	}

	@Override
	public boolean verifyDate(Check check) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date1, date2;
		try {
			date1 = sdf.parse(check.getCheckDate().toString());
			date2= new Date();
			if(date1.after(date2)){
	    		System.out.println("Date1 is after Date2");
	    		return false;
	    	}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	
    	
		return true;
	}

}
