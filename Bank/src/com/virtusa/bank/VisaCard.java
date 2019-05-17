package com.virtusa.bank;

import java.io.InvalidObjectException;

public class VisaCard extends CreditAccount {
	
	
	
	@Override
	public void withdraw(Double amount) {
		
		System.out.println("Withdraw made from Credit Account class");
	}

	
	public boolean  validateCardNo(String CardNo) throws InvalidObjectException, CreditAccountException, AccountException
	{
		try {
			try {
			if(validateAccount(CardNo)) {
		
				if(CardNo.startsWith("812"))
					return true;
				throw new InvalidObjectException("Invalid card No");
			}
			else
			{
				throw new CreditAccountException("Invalid Account Number");
			}
			}
			catch (AccountException e) {
				throw new CreditAccountException("Account Validation failed",e);
			}
		}
		catch(IllegalArgumentException iae)
		{
			throw new CreditAccountException("Account Validation failed",iae);
		}
	}
			
}
