package com.virtusa.bank;

import java.io.InvalidObjectException;

public class CreditCard extends VisaCard {

	
@Override
 public void withdraw(Double amount) {
	try {
		if(validateCardNo("8126")) {
			super.withdraw(amount);
		}
	} catch (CreditAccountException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (InvalidObjectException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (AccountException ae)
	{
		ae.printStackTrace();
	}
	
	}
//
//	
	

}
