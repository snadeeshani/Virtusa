package com.codelabs.emp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;



@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	Address address;
	
	@Transient
	Allocation[] allocation;
	
	
	public Allocation[] getAllocation() {
		return allocation;
	}
	public void setAllocation(Allocation[] allocation) {
		this.allocation = allocation;
	}
	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	List<Telephone> telephones;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="employee_project",
	joinColumns=@JoinColumn(name="eid", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="pid",referencedColumnName="id"))
	
	List<Project>project;
	
	
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Telephone> getTelephones() {
		return telephones;
	}
	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}
	
	
	
}
