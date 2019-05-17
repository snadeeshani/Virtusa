package com.virtusa.bank;

public class CreditAccountException extends Exception{

	public CreditAccountException()
	{
		super();
	}
	public CreditAccountException(String message)
	{
		super(message);
	}
	public CreditAccountException(String message,Throwable cause)
	{
		super(message,cause);
	}
	
	
}
