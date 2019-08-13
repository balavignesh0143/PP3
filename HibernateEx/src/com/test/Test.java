package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.file.Employee;

public class Test {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();// to load configuration file

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Employee emp = (Employee) session.get(Employee.class, new Integer(111));// fetching the details

		Employee e = (Employee) emp;// updating the details

		session.delete(e);// delete the details from db
		/*
		 * e.setEsal(50000); session.update(e);//updating the details
		 */
		/*
		 * System.out.println("Employee ID : "+emp./getEid());//fetching the details
		 * System.out.println("Employee Name : "+emp.getEname());
		 * System.out.println("Employee Salary : "+emp.getEsal());
		 */
		// dml
		Transaction tran = session.beginTransaction();// for using update and insert

		/*
		 * Employee emp = new Employee(111, "Balavignesh", 20000); session.save(emp);//
		 * insert,ORM
		 */

		tran.commit();// we need to give for update and insert

		session.close();
		factory.close();
	}
}
