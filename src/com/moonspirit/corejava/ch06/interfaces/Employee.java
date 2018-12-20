package com.moonspirit.corejava.ch06.interfaces;

public class Employee implements Comparable<Employee> {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

	public void raiseSalary(double percent) {
		double raise = salary * percent / 100;
		salary += raise;
	}

	@Override
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}
}
