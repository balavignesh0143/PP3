
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestClient {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("a");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
/*		Employee e=new Employee(111,"Bala",10000);
		Employee e1=new Employee(222,"Vignesh",20000);
		Employee e2=new Employee(333,"Geetha",70000);
		Employee e3=new Employee(444,"Fareeth",90000);
		em.persist(e);
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);*/

		//inserting the details using jpql
		/*TypedQuery<Employee> q1=em.createQuery("select c from Employee c",Employee.class);
		List<Employee> l1=q1.getResultList();
		for(Employee emp:l1)
		{
			System.out.println("Employee ID : "+emp.getEmpId());
			System.out.println("Employee Name : "+emp.getEmpName());
			System.out.println("Employee Salary : "+emp.getEmpSal());
		}*/
		
/*		Query q2=em.createQuery("select c from Employee c");
		List<Employee> l2=q2.getResultList();
		for(Employee emp1:l2)
		{
			System.out.println("Employee ID : "+emp1.getEmpId());
			System.out.println("Employee Name : "+emp1.getEmpName());
			System.out.println("Employee Salary : "+emp1.getEmpSal());
		}*/
		
		//update
		/*Query query=em.createQuery("update Employee set empSal=150000 where empSal<90000");
		query.executeUpdate();*/
		
		//delete
		/*Query query=em.createQuery("delete from Employee where empId=444");
		query.executeUpdate();*/
		
		//sorting
		Query query=em.createQuery("select MAX(e.empSal) FROM Employee e");
		int maxSal=(int) query.getSingleResult();
		System.out.println(maxSal);
		
		em.getTransaction().commit();
		//System.out.println("Updated...");
		//System.out.println("Deleted...");
		//System.out.println("Sorting...");
		em.close();
		emf.close();
	}
}
