package com.sentornCompany;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable{

	private String name;
	private String lastName;
	private int age;
	private double salary;
	private String address;
	
	public Employee() {
		
	}

	public Employee(String name, String lastName, int age, double salary,
			String address) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", lastName: " + lastName + ", age: " + age
				+ ", salary: " + salary + ", address: " + address;
	}

	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Employee e = (Employee) obj;

		boolean c = this.name != null && this.name.equals(e.name)
				&& this.lastName != null && this.lastName.equals(e.lastName)
				&& this.age != 0 && this.age == e.age && this.salary != 0
				&& this.salary == e.salary && this.address != null
				&& this.address.equals(e.address);
		return c;
	}
	
	public int hashCode() {
		int res = 1;
		res = res + (this.name != null ? this.name.hashCode() : 0);
		res = res + (this.lastName != null ? this.lastName.hashCode() : 0);
		res = res + this.age;
		res = (int)(res + this.salary);
		res = res + (this.address != null ? this.address.hashCode() : 0);
		return res;
	}
}
