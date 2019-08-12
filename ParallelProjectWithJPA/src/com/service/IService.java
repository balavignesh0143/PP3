package com.service;

public interface IService{
	public int createAccount(String name, long mblNo, int accNo, double balance);
	public double showBalance(int accNo);
	public double depositBalance(int accNo, double balance);
	public double withdrawBalance(int accNo,double balance);
	public double validationBal(double balance);
	public String validationName(String name);
	public long validationMblNo(long mblNo);


}
