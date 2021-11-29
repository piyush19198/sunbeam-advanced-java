package com.sunbeam;

public class AccountImpl implements Account {
	private int id;
	private String type;
	private double balance;
	private Logger logger;
	private Person accHolder;
	
	public AccountImpl() {
	}
	public AccountImpl(int id, String type, double balance) {
		this.id = id;
		this.type = type;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	
	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", logger=" + logger
				+ ", accHolder=" + accHolder + "]";
	}
	@Override
	public void deposit(double amount) {
		if(logger != null)
			logger.log("Deposit Rs. " + amount + " into account " + this.id);
		this.balance = this.balance + amount;
	}
	@Override
	public void withdraw(double amount) {
		if(logger != null)
			logger.log("Withdraw Rs. " + amount + " from account " + this.id);
		this.balance = this.balance - amount;
	}
}

