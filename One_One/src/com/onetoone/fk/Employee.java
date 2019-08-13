package com.onetoone.fk;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "emp1to11")

public class Employee {
	@Id
	@Column(name = "empid", length = 10)
	private int eid;

	public Employee(int eid, String ename, int esal, Address add) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", add=" + add + "]";
	}

	@Column(name = "empname", length = 10)
	private String ename;
	@Column(name = "empsal", length = 10)
	private int esal;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aid")
	private Address add;// has-a

	public int getEsal() {
		return esal;
	}

	public void setEsal(int esal) {
		this.esal = esal;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

}