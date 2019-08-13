package com.onetoone.fk;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Address {
	public Address() {

	}

	public Address(int aid, int hno, String colony, String city) {
		super();
		this.aid = aid;
		this.hno = hno;
		this.colony = colony;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", hno=" + hno + ", colony=" + colony + ", city=" + city + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	@Column(name = "houseno", length = 10)
	private int hno;
	@Column(length = 10)
	private String colony;
	@Column(length = 10)
	private String city;
	
	@OneToOne(mappedBy="add",cascade=CascadeType.ALL)
	@JoinColumn(name="aid")
	private Employee employee;
	
	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String string) {
		this.city = string;
	}

}