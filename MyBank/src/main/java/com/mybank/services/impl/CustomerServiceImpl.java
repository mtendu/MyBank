package com.mybank.services.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.mybank.common.constants.AttributeType;
import com.mybank.common.constants.PhoneAvalTime;
import com.mybank.pojo.Customer;
import com.mybank.pojo.CustomerAddress;
import com.mybank.pojo.CustomerDemographics;
import com.mybank.pojo.CustomerPhone;
import com.mybank.services.CustomerServices;

public class CustomerServiceImpl implements CustomerServices{

	@Override
	public Customer createUser(String userName, String password) {
		Customer customer = new Customer(userName, password);
		return customer;
	}

	@Override
	public void updateName(Customer customer, String firstName, String middleName,
			String lastName, String suffix, String prefix, String dateOfBirth, String gender, String ssn) {
		
		CustomerDemographics demo = new CustomerDemographics(customer, AttributeType.USER_INFO);
		demo.setFirstName(firstName);
		demo.setMiddleName(middleName);
		demo.setLastName(lastName);
		demo.setSuffix(suffix);
		demo.setPrefix(prefix);
		demo.setDateOfBirth(dateOfBirth);
		demo.setGender(gender);
		demo.setSsn(ssn);

		
	}

	@Override
	public void updatePassword(Customer customer, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddressPhone(Customer customer, 
			AttributeType addrAttrType, 
			String stLine1, String stLine2, String city, String state, String zipCode, 
			AttributeType phnAttrType,
			String phoneArea, String phoneNumber, String phoneExt, PhoneAvalTime avalTime) {
		
		if (!StringUtils.isEmpty(stLine1) 
				&& !StringUtils.isEmpty(city)
				&& !StringUtils.isEmpty(state)) {
			CustomerAddress customerAddress = new CustomerAddress(customer, addrAttrType);
			customerAddress.setStLine1(stLine1);
			customerAddress.setStLine2(stLine2);
			customerAddress.setCity(city);
			customerAddress.setState(state);
			customerAddress.setZipCode(zipCode);
		}
		
		if (!StringUtils.isEmpty(phoneNumber)) {
			
			CustomerPhone customerPhone = new CustomerPhone(customer, phnAttrType);
			customerPhone.setPhoneArea(phoneArea);
			customerPhone.setPhoneNumber(phoneNumber);
			customerPhone.setPhoneExt(phoneExt);
			customerPhone.setPhoneAvalTimeSet(avalTime);
			
		}
		
	}

	

}
