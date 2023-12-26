package com.Bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
	
	@Id
	private long account_number;
	
	private  String name;

	private String password;
	private String confirmpassword;
	private long mobile_number;
	private double amount;
	private String address;
	public Bank() {
		super();
	}
	public Bank(long account_number, String name, String passowrd, String confirmpassowrd, long mobile_number,
			double amount, String address) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.password = passowrd;
		this.confirmpassword = confirmpassowrd;
		this.mobile_number = mobile_number;
		this.amount = amount;
		this.address = address;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassowrd() {
		return password;
	}
	public void setPassowrd(String passowrd) {
		this.password = passowrd;
	}
	public String getConfirmpassowrd() {
		return confirmpassword;
	}
	public void setConfirmpassowrd(String confirmpassowrd) {
		this.confirmpassword = confirmpassowrd;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Bank [account_number=" + account_number + ", name=" + name + ", passowrd=" + password
				+ ", confirmpassowrd=" + confirmpassword + ", mobile_number=" + mobile_number + ", amount=" + amount
				+ ", address=" + address + "]";
	}
	
	
	

}
