package com.Bank.service;

import java.util.List;

import com.Bank.model.Bank;



public interface Bankservice {

	public Bank savecustomer(Bank bank);
	public Bank updatecustomer(Bank bank);
	public Bank withdrawamount(Bank bank);
	public void deletecustomer(long aaccount_number);
	public Bank getcustomer(long account_number, String name, String password);
	public List<Bank>getAllcustomer();
	public Bank deposite(long aaccount_number,double amount,Bank bank);
	
	public Bank withdraw(Bank bank,long aaccount_number,double amount);
}
