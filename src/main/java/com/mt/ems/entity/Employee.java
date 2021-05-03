package com.mt.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class Employee implements Comparable<Employee>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "EMP_NAME")
	private String name;
	
	@Column(name = "EMP_SAL")
	private double salary;
	
	@Column(name = "EMP_DEPT")
	private String dept;

	public Employee(String name, double salary, String dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

//	public Employee() {
//		super();
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public double getSalary() {
//		return salary;
//	}
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//
//	public String getDept() {
//		return dept;
//	}
//
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
//	}

	@Override
	public int compareTo(Employee o) {
		
		int compare=name.compareTo(o.name);
		if(compare==0)
		{
			compare=Double.compare(salary, o.salary);
		}
		return compare;
	}
	
	
}
