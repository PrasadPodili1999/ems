package com.mt.ems.exceptionhandler;

public class EmployeeNotFoundException extends Exception{

	public EmployeeNotFoundException()
	{
		super();
	}
	public EmployeeNotFoundException(String msg)
	{
		super(msg);
	} 
	public EmployeeNotFoundException(String msg,Throwable cause)
	{
		super(msg,cause);
	}
	public EmployeeNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
