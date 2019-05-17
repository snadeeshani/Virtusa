package com.virtusa.bank;

public class CreditAccount extends Account{

	boolean validateAccount(String accountNo) throws AccountException
	
	{
		try
		{
			if(accountWithdrawValidation())
			{
		
				if(accountNo.length()>5)
		
					return true;
				throw new IllegalArgumentException("Account No should length over 5 digits");
			}
			else
			{
			return false;
			}
		}
		catch(AccountException ae)
		{
			throw new AccountException("Withdraw count validation failed",ae);
		}
	}
	
	
	
	
}
