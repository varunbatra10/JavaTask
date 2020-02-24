package com.versionOne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeecard")
public class EmployeeCard {

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	@Id
	@Column(name = "employeecard_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "number", nullable = false)
	private String Number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
