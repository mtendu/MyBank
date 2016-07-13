package com.mybank.services;

import com.mybank.common.constants.AttributeType;
import com.mybank.common.constants.PhoneAvalTime;
import com.mybank.pojo.Customer;

public interface CustomerServices {
	
	public Customer createUser(String userName, String password);

	public void updateName(Customer customer, 
			String firstName, String middleName, String lastName, String suffix, String prefix,
			String dateOfBirth,String gender, String ssn);
	
	public void updateAddressPhone(Customer customer, 
			AttributeType addrAttrType, 
			String stLine1, String stLine2, String city, String state, String zipCode, 
			AttributeType phnAttrType,
			String phoneArea, String phoneNumber, String phoneExt, PhoneAvalTime avalTime);
		
	public void updatePassword(Customer customer, String password);

}
