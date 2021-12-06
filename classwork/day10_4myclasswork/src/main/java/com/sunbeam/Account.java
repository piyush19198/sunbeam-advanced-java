package com.sunbeam;

public interface Account {
	int getId();

	void setId(int id);

	String getType();

	void setType(String type);

	double getBalance();

	void setBalance(double balance);

	Logger getLogger();

	void setLogger(Logger logger);

	void deposit(double amount);

	void withdraw(double amount);
}
