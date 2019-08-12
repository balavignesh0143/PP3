package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankWallet")
public class Details {
	@Id
	@Column(name = "accno", length = 20)
	private int accNo;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "mobile", length = 20)
	private long mblNo;
	@Column(name = "balance", length = 20)
	private double balance;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMblNo() {
		return mblNo;
	}

	public void setMblNo(long mblNo) {
		this.mblNo = mblNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Details(int accNo, String name, long mblNo, double balance) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.mblNo = mblNo;
		this.balance = balance;
	}

	public Details() {

	}

	@Override
	public String toString() {
		return "Details [accNo=" + accNo + ", name=" + name + ", mblNo=" + mblNo + ", balance=" + balance + "]";
	}

}
