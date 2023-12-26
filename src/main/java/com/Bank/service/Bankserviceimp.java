package com.Bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.model.Bank;
import com.Bank.repo.Bankrepo;

@Service
public class Bankserviceimp implements Bankservice {

	@Autowired
	private Bankrepo repo;
	
	@Override
	public Bank savecustomer(Bank bank) {
		
		return repo.save(bank);
		
	}

	@Override
	public Bank updatecustomer(Bank bank) {
		
	Bank prbalance=repo.findById(bank.getAccount_number()).get();
	
	
	double totbal=prbalance.getAmount()+bank.getAmount();
	
	
	bank.setAmount(totbal);
	
	
		Bank b=repo.save(bank);
	
	
		
		return bank;
	}

	@Override
	public void deletecustomer(long account_number) {
		repo.deleteById(account_number);

	}

	@Override
	public Bank getcustomer(long account_number, String name, String password) {
		Bank getone=repo.findById(account_number).get();
	
		
		return getone;
	}

	@Override
	public List<Bank> getAllcustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Bank withdrawamount(Bank bank) {
		
		Bank prbalance=repo.findById(bank.getAccount_number()).get();
		
		if(prbalance.getAmount()>=bank.getAmount())
		{
		double totbal=prbalance.getAmount()-bank.getAmount();
		bank.setAmount(totbal);
		repo.save(bank);
		System.out.println("Withdraw successful.....");
		}
		else
		{
			System.out.println("Low balance.....");
		}
		
		return repo.save(bank);
	}
		
		@Override
		public Bank deposite(long taccount_number,double amount,Bank bank)
		{
			Bank getone=repo.findById(taccount_number).get();
			double tot=getone.getAmount()+amount;
			
			bank.setAmount(tot);
			return repo.save(bank);
		}

		
		@Override
		public Bank withdraw(Bank bank,long saccount_number,double amount) {
			Bank getone=repo.findById(saccount_number).get();
			double tot=getone.getAmount()-amount;
			
			bank.setAmount(tot);
			return repo.save(bank);
		}
		
	
}

