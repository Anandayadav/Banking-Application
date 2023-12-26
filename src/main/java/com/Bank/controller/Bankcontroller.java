package com.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bank.model.Bank;
import com.Bank.service.Bankserviceimp;

@Controller
public class Bankcontroller {
	
	@Autowired
	private Bankserviceimp service;
	
	
	@RequestMapping("/")
	public String home()
	{
		return"home";
	}
	
	@RequestMapping("/newaccount")
	public String openaccount()
	{
		return"register";
	}
	
	@RequestMapping("/saved")
	public String save(Bank bank,ModelMap model)
	{
		Bank b1=service.savecustomer(bank);
		model.put("Name", bank.getName());
		return "success";
	}
	
	@RequestMapping("/balanceform")
	public String balancePage()
	{
		return"balance";
	}
	
	@RequestMapping("/balance")
	public String showBalance(@RequestParam long account_number,@RequestParam String name,@RequestParam String password,ModelMap model)
	{
		String iname=name;
		String ipassword=password;
		long accountno=account_number;
		Bank b1=service.getcustomer(account_number,name,password);
		String s=null;
		
		if(iname.equals(b1.getName()) && accountno==b1.getAccount_number())
		{
			
			model.put("Ano", b1.getAccount_number());
			model.put("Name", b1.getName());
			model.put("Amount", b1.getAmount());
			
		}
		else
		{
			s="No such account found.Reassure inputs once.....";
		}
		
		model.put("Message", s);
		
		return "showbalance";
	}
	
	@RequestMapping("/depositform")
	public String depositePage()
	{
		
		return"depositform";
	}
	
	@RequestMapping("/deposit")
	public String showdeposit(Bank bank,ModelMap model)
	{
		model.put("depoamount",bank.getAmount());
		Bank b1=service.getcustomer(bank.getAccount_number(),bank.getName(),bank.getPassowrd());
		model.put("presentbal",b1.getAmount());
		
		
		Bank b2=service.updatecustomer(bank);
		model.put("totbal", b2.getAmount());
		
		return "showdeposite";
	}
	
	@RequestMapping("/withdrawform")
	public String withdrawPage()
	{
		
		return"withdrawform";
	}
	
	
	@RequestMapping("/withdraw")
	public String withdraw(Bank bank,ModelMap model)
	{
		model.put("withamount",bank.getAmount());
		Bank b1=service.getcustomer(bank.getAccount_number(),bank.getName(),bank.getPassowrd());
		model.put("presentbal",b1.getAmount());
		String s="null";
		
		if(bank.getAmount()<=b1.getAmount())
		{
			s="Withdrawl successful....";
			model.put("message",s);
		Bank b2=service.withdrawamount(bank);
		Bank b3=service.getcustomer(bank.getAccount_number(),bank.getName(),bank.getPassowrd());
		model.put("totbal", b3.getAmount());
		}
		else {
			s="Withdrawl unsuccssful due to Low balnce.........";
			model.put("message",s);
		}
		
		
		return "showwithdraw";
	}
	
	@RequestMapping("/transferform")
	public String transferPage()
	{
		
		return"transferform";
	}
	
	@RequestMapping("/transfer")
	public String transfer(@RequestParam long saccount_number,@RequestParam long taccount_number,@RequestParam String name,@RequestParam String password,@RequestParam double amount,ModelMap model)
	{
		model.put("tranferamount",amount);
		Bank b1=service.getcustomer(saccount_number,name,password);
		model.put("spresentbal",b1.getAmount());
		model.put("sname",b1.getName());
		
		
		Bank b2=service.getcustomer(taccount_number, name, password);
		model.put("tamount", b2.getAmount());
		model.put("tname",b2.getName());
		String s=null;
		
		if(b1.getAmount()>=amount)
		{
		Bank b3=service.deposite(taccount_number, amount, b2);
		model.put("atransfert", b3.getAmount());
		
		Bank b4=service.withdraw(b1, saccount_number, amount);
		model.put("atransfers", b4.getAmount());
		s="Transfer Successful......";
		}
		else
		{
			s="Transfer Insuccessful due to low balnce at source account......";
		}
		model.put("message", s);
		
		return "showtransfer";
	}
	@RequestMapping("/closeaccountform")
	public String close()
	{
		return"closeaccount";
	}
	
	@RequestMapping("/close")
	public String closeaccount(Bank bank)
	{
		service.deletecustomer(bank.getAccount_number());
		
		return"showclose";
	}
	
	
	
	
	@RequestMapping("/about")
	public String about()
	{
		return"about";
	}
	
	

}
