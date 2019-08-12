package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bean.Details;
import com.service.ServiceImpl;

public class DAOImpl implements IDAO {
	Details ud = new Details();
	ServiceImpl s;
	EntityManager conn;
	DB db = new DB();

	public int createAccount(Details ud) {
		conn = db.getConnection();
		conn.getTransaction().begin();
		conn.persist(ud);
		conn.getTransaction().commit();
		return ud.getAccNo();
	}

	@Override
	public double showBalance(int accNo) {
		conn = db.getConnection();
		conn.getTransaction().begin();
		ud = conn.find(Details.class, accNo);
		conn.getTransaction().commit();
		return ud.getBalance();
	}

	public double depositBalance(int accNo, double balance) {
		conn = db.getConnection();
		conn.getTransaction().begin();
		ud = conn.find(Details.class, accNo);
		if (ud == null) {
			System.out.println("Invalid");
		} else {
			double originalBal=ud.getBalance();
			double mainBal=originalBal+balance;
			Query query = conn.createQuery("update Details d set d.balance=:mainBal_1 where d.accNo=:accNo_1");
			query.setParameter("mainBal_1",mainBal);
			query.setParameter("accNo_1",accNo);
			query.executeUpdate();
		}
		conn.getTransaction().commit();
		return ud.getBalance();
	}

	public double withdrawBalance(int accNo, double balance){
		conn = db.getConnection();
		conn.getTransaction().begin();
		ud = conn.find(Details.class, accNo);
		if (ud == null) {
			System.out.println("Invalid");
		}else {
			double originalBal=ud.getBalance();
			double mainBal=originalBal-balance;
			Query query = conn.createQuery("update Details d set d.balance=:mainBal_1 where d.accNo=:accNo_1");
			query.setParameter("mainBal_1",mainBal);
			query.setParameter("accNo_1",accNo);
			query.executeUpdate();
		}
		conn.getTransaction().commit();
		return ud.getBalance();
	}

	/*public double fundTransfer(int accNo, int accNo1, double balance) {
		
		conn=db.getConnection();
		conn.getTransaction().begin();
		ud=conn.find(Details.class,accNo);
		if(ud==null)
		{
			System.out.println("Invalid");
		}
		else {
			Query query=conn.createQuery("select c from Details c");
			ud.setAccNo(accNo);
			ud.setAccNo(accNo1);
			query.executeUpdate();
			double mainBal;
			if()
			{
				
			}
			
		}
		conn.getTransaction().commit();

		
		if (rs.next()) {
			double originalBal = rs.getDouble("balance");
			conn = StoreDB.getConnection();
			String transfer = "update userdetails set balance=?  where accno=?";
			PreparedStatement pstmt = conn.prepareStatement(transfer);
			mainBal = originalBal - balance;
			pstmt.setDouble(1, mainBal);
			pstmt.setInt(2, accNo);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				String name = rs.getString("name");
				long mblNo = rs.getLong("mblNo");
				System.out.println("\n");
				System.out.println("Transfer completed...");
				System.out.println("Account holder name: " + name);
				System.out.println("Account holder mobile number: " + mblNo);
				System.out.println("New balance: " + mainBal);
			}
		} 
		return balance;
	}
*/
}