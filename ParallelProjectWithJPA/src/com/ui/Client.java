package com.ui;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.exceptions.AccountNotFoundException;
import com.service.IService;
import com.service.ServiceImpl;

public class Client {
	public int getOption(Scanner sc) {
		try {
			int option = sc.nextInt();
			return option;
		} catch (Throwable e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int option;
		Scanner sc = new Scanner(System.in);
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
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter your name:");
				String name = s.validationName(sc.next());
				System.out.println("Enter your mobile number:");
				long mblNo = s.validationMblNo(sc.nextLong());
				Random r = new Random();// random method used for creating a random account number
				int accNo = r.nextInt(100000000);// limit
				System.out.println("Enter your initial amount: ");
				double balance = s.validationBal((sc.nextDouble()));// validating the balance which is greater than zero
																	// or not
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
					accNo = sc.nextInt();
					double bal = s.showBalance(accNo);
					System.out.println("Current balance : " + bal);
				} catch (AccountNotFoundException ex) {
					System.out.println("Invalid account number...");
				}
				break;
			case 3:
				try {
					System.out.println("Enter your account number: ");
					accNo = sc.nextInt();
					System.out.println("Enter your deposit amount: ");
					balance = s.validationBal(sc.nextDouble());// validating the balance which is greater than zero or
																// not
					s.depositBalance(accNo, balance);// passing the arguments to service class
					System.out.println("Deposited successfully...");
					//System.out.println("Deposited amount : " + balance);
					//System.out.println("After deposited available balance : " + bal);
				} catch (AccountNotFoundException ex) {
					System.out.println("Invalid account number...");
				}
				break;
			case 4:
				try {
					System.out.println("Enter the account number: ");
					accNo = sc.nextInt();
					System.out.println("Enter your withdraw amount: ");
					balance = s.validationBal(sc.nextDouble());// validating the balance which is greater than zero or
																// not
					s.withdrawBalance(accNo, balance);// passing the arguments to service class
					System.out.println("\n");
					System.out.println("Withdraw completed....");
					//System.out.println("Withdrawn amount : " + balance);
					//System.out.println("After withdraw available balance: " + bal);
				} catch (AccountNotFoundException e) {
					System.out.println("Invalid account number...");
				}
				break;
/*			case 5:
				try {
					System.out.println("Enter your account number: ");
					accNo = sc.nextInt();
					System.out.println("Enter the account number to transfer: ");
					int accNo1 = sc.nextInt();
					System.out.println("Enter the transfer amount: ");
					balance = sc.nextDouble();
					double bal = s.fundTransfer(accNo, accNo1, balance);
					System.out.println("\n");
					System.out.println("Transfer completed.....");
					System.out.println("After transaction your current balance is " + bal);
				} catch (AccountNotFoundException e) {
					System.out.println("Invalid account number...");
				}
				break;*/

			/*
			 * case 6: try { System.out.println("Enter the account number: ");
			 * accNo=sc.nextInt(); List<?> l=c.printTrans(accNo); Iterator<?>
			 * i=l.iterator(); { while(i.hasNext()) { TransferDetails td=(TransferDetails)
			 * i.next(); System.out.println("\n");
			 * System.out.println("Transaction ID: "+td.getTransId());
			 * System.out.println("Account from: "+td.getAccNoFrom());
			 * System.out.println("Account type: "+td.getTransType());
			 * System.out.println("Account to: "+td.getAccNoTo());
			 * System.out.println("Date of transaction: "+td.getDateOfTrans());
			 * System.out.println("Transfer amount: "+td.getTransferAmt());
			 * System.out.println("Balance: "+td.getBalance()); System.out.println("\n");
			 * 
			 * }
			 * 
			 * } } catch(AccountNotFoundException e) { System.out.println(e); } break;
			 */
			case 7:
				System.out.println("Thank for using our service!!!");
				System.out.println("Regards\nXYZ BANK WALLET...");
				break;
			default:
				System.out.println("Thanks.....");
				break;
			}
		} while (option != 7);
		sc.close();
	}
}
