package com.service;

import java.util.Scanner;

import com.bean.Details;
import com.dao.DAOImpl;
import com.dao.IDAO;

public class ServiceImpl implements IService {
	Scanner sc = new Scanner(System.in);
	Details ud = new Details();
	IDAO d = new DAOImpl();

	public int createAccount(String name, long mblNo, int accNo, double balance) {
		Details ud = new Details();

		ud.setName(name);
		ud.setBalance(balance);
		ud.setAccNo(accNo);
		ud.setMblNo(mblNo);
		return d.createAccount(ud);
	}

	@Override
	public double showBalance(int accNo) {
		double acc = d.showBalance(accNo);
		return acc;
	}

	public double depositBalance(int accNo, double balance) {
		double acc = d.depositBalance(accNo, balance);
		return acc;
	}

	public double withdrawBalance(int accNo, double balance) {
		double acc=d.withdrawBalance(accNo, balance);
		return acc;
	}

/*	public double fundTransfer(int accNo, int accNo1, double balance) {
		double acc=d.fundTransfer(accNo, accNo1, balance);
		return acc;
	}*/

	public double validationBal(double balance) {
		while (true) {
			if (balance <= 0) {
				System.out.println("Amount is lesser than zero...");
				System.out.println("Enter the amount again: ");
				balance = (long) sc.nextDouble();
			} else {
				return balance;
			}
		}
	}

	public String validationName(String name) {
		if (name.matches("[A-Z][a-zA-Z]*"))
			return name;
		else
			System.out.println("Enter valid name: ");
		return name = sc.next();
	}

	public long validationMblNo(long mblNo) {
		while (true) {
			if (String.valueOf(mblNo).length() == 10) {
				return mblNo;
			} else {
				System.out.println("Enter the valid mobile number: ");
				mblNo = sc.nextLong();
			}
		}
	}

}
