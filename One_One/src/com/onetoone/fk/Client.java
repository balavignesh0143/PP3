package com.onetoone.fk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("one-one");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Address ad1 = new Address();
		ad1.setHno(1214);
		ad1.setColony("LNagar");
		ad1.setCity("Tup");
		em.persist(ad1);

		Employee e = new Employee();
		e.setEid(222);
		e.setEname("Vignesh");
		e.setEsal(50000);
		e.setAdd(ad1);
		em.persist(e);

		/*Employee e=em.find(Employee.class,111);
		em.remove(e);
		Address a=em.find(Address.class,1);
		em.remove(a);*/
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}