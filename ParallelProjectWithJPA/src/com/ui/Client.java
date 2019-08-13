package com.ui;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bean.TransferDetails;
import com.exceptions.AccountNotFoundException;
import com.service.IService;
import com.service.ServiceImpl;

public class Client {
	public int getOption(Scanner scanner) {
		try {
			int option = scanner.nextInt();
			return option;
		} catch (Throwable e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int option;
		Scanner scanner = new Scanner(System.in);
		IService s = new ServiceImpl();
		do {
			System.out.println(
					"*******************************************************************************************************");
			System.out.println("\t\t\t\tXYZ BANK WALLET");
			System.out.println(
					"*******************************************************************************************************");
			System.out.println("\n1)Create Account...");
			System.out.println("2)Show Balance...");
			System.out.println("3)Deposit...");
			System.out.println("4)Withdraw...");
			System.out.println("5)Fund Transfer...");
			System.out.println("6)Print Transaction...");
			System.out.println("7)Exit...");
			System.out.println("Enter your option: ");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter your name:");
				String name = s.validationName(scanner.next());
				System.out.println("Enter your mobile number:");
				long mblNo = s.validationMblNo(scanner.nextLong());
				Random r = new Random();// random method used for creating a random account number
				int accNo = r.nextInt(100000000);// limit
				System.out.println("Enter your initial amount: ");
				double balance = s.validationBal((scanner.nextDouble()));// balance which is greater than zero or not
				s.createAccount(name, mblNo, accNo, balance);// passing the details to service class
				System.out.println("Account created....");
				System.out.println("Your name: " + name);
				System.out.println("Your mobile number: " + mblNo);
				System.out.println("Your new account number: " + accNo);
				System.out.println("Your initial balance: " + balance);
				break;
			case 2:
				try {
					System.out.println("Enter your account number: ");
					accNo = scanner.nextInt();
					double bal = s.showBalance(accNo);
					System.out.println("Customer Current balance : " + bal);
				} catch (AccountNotFoundException ex) {
					System.out.println("Invalid account number...");
				}
				break;
			case 3:
				try {
					System.out.println("Enter your account number: ");
					accNo = scanner.nextInt();
					System.out.println("Enter your deposit amount: ");
					balance = s.validationBal(scanner.nextDouble());// balance which is greater than zero or not
					s.depositBalance(accNo, balance);// passing the arguments to service class
					System.out.println("Deposited successfully...");
				} catch (AccountNotFoundException ex) {
					System.out.println("Invalid account number...");
				}
				break;
			case 4:
				try {
					System.out.println("Enter the account number: ");
					accNo = scanner.nextInt();
					System.out.println("Enter your withdraw amount: ");
					balance = s.validationBal(scanner.nextDouble());// balance which is greater than zero or not
					s.withdrawBalance(accNo, balance);// passing the arguments to service class
					System.out.println("\n");
					System.out.println("Withdraw completed....");
				} catch (AccountNotFoundException ex) {
					System.out.println("Invalid account number...");
				}
				break;
			case 5:
				try {
					System.out.println("Enter your account number: ");
					accNo = scanner.nextInt();
					System.out.println("Enter the account number to transfer: ");
					int accNo1 = scanner.nextInt();
					System.out.println("Enter the transfer amount: ");
					balance = scanner.nextDouble();
					s.fundTransfer(accNo, accNo1, balance);
					System.out.println("\n");
					System.out.println("Transfer completed.....");
				} catch (AccountNotFoundException ex) {
					System.out.println("Invalid account number...");
				}
				break;
			case 6:
				try {
					System.out.println("Enter the account number: ");
					accNo = scanner.nextInt();
					List<?> list = s.printTransactions(accNo);
					Iterator<?> iterator = list.iterator();
					{
						while (iterator.hasNext()) {
							TransferDetails td = (TransferDetails) iterator.next();
							System.out.println("\n");
							System.out.println("Transaction ID: " + td.getTransId());
							System.out.println("Account from: " + td.getAccNoFrom());
							System.out.println("Account type: " + td.getTransType());
							System.out.println("Account to: " + td.getAccNoTo());
							System.out.println("Date of transaction: " + td.getDateOfTrans());
							System.out.println("Transfer amount: " + td.getTransferAmt());
							System.out.println("Balance: " + td.getBalance());
							System.out.println("\n");
						}
					}
				} catch (AccountNotFoundException ex) {
					System.out.println("Invalid account number...");
				}
				break;
			case 7:
				System.out.println("Thank for using our service!!!");
				System.out.println("Regards\nXYZ BANK WALLET...");
				break;
			default:
				System.out.println("Thanks.....");
				break;
			}
		} while (option != 7);
		scanner.close();
	}
}
