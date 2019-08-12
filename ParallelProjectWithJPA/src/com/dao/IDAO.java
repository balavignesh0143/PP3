package com.dao;

import com.bean.Details;

public interface IDAO {

	int createAccount(Details ud);

	double showBalance(int accNo);

	double depositBalance(int accNo, double balance);

	double withdrawBalance(int accNo, double balance);




}
