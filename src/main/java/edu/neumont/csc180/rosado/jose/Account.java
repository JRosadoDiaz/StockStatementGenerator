package edu.neumont.csc180.rosado.jose;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private Long accountNumber;
	private String ssn;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String beginningBalance;
	private List<StockTrade> stockTrades = new ArrayList<>();
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long long1) {
		this.accountNumber = long1;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBeginningBalance() {
		return beginningBalance;
	}
	public void setBeginningBalance(String beginningBalance) {
		this.beginningBalance = beginningBalance;
	}
	public List<StockTrade> getStockTrades() {
		return stockTrades;
	}
	
}