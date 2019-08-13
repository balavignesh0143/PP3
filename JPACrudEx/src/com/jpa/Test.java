package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test {
	public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("a");
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
	
	Employee emp=new Employee();
	emp.setEmpName("Vignesh");
	emp.setEmpSal(1111111);
	em.persist(emp);
	//Employee e=new Employee(111,"Bala",20000);//inserting the details into db
	//Employee e1=new Employee(222,"Vignesh",10000);
	//em.persist(e);
	//em.persist(e1);
	
	/*Employee emp =em.find(Employee.class,111);//fetching the details
	System.out.println("Employee ID: "+emp.getEmpid());
	System.out.println("Employee Name: "+emp.getEmpName());
	System.out.println("Employee Salary: "+emp.getEmpSal());*/
	
	/*Employee emp=em.find(Employee.class,111);//updating the details
	System.out.println("Before Updation");
	System.out.println("Employee ID: "+emp.getEmpid());
	System.out.println("Employee Name: "+emp.getEmpName());
	System.out.println("Employee Salary: "+emp.getEmpSal());
	
	emp.setEmpName("Balavignesh");
	emp.setEmpSal(50000);
	
	System.out.println("After Updation");
	System.out.println("Employee ID: "+emp.getEmpid());
	System.out.println("Employee Name: "+emp.getEmpName());
	System.out.println("Employee Salary: "+emp.getEmpSal());*/
	
	/*Employee emp=em.find(Employee.class,222);//deleting the details
	em.remove(emp);*/
	/*Employee e=(Employee)emp;
	e.setEmpSal(55000);
	EntityManager.merge();*/
	
	em.getTransaction().commit();
	em.close();
	emf.close();
	//System.out.println("Deleted...");
	//System.out.println("Inserted...");
	}
}
