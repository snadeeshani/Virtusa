package com.virtusa.bank;

public class Account {

	int withdrawCount=5;
	public boolean accountWithdrawValidation() throws AccountException
	{
		if(withdrawCount>=3)
		{
			return true;
		}
		else
		{
			throw new AccountException("Withdraw count exceeded");
		}
	}
	public void withdraw(Double amount) {
		
		
	}
}
