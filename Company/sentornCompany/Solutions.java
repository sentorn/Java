package com.sentornCompany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solutions {

	private List<User> userList = new ArrayList<User>();
	private List<Employee> empList = new ArrayList<Employee>();

	void saveEmployee(String name, String lastName, int age, double salary,
			String address) {
		empList.add(new Employee(name, lastName, age, salary, address));
	}

	void saveUser(String login, String password) {
		userList.add(new User(login, password));
	}

	String getAllEmp() {
		String s = "";
		for (int i = 0; i < empList.size(); i++) {
			s += i + 1 + ". " + empList.get(i).toString() + "\n";
		}
		return s;
	}

	boolean userExist(User user) {
		boolean res = false;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).equals(user)) {
				res = true;
				i = userList.size();
			}
		}
		return res;
	}

	boolean employeeExist(String s) {
		boolean res = false;
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getLastName().equals(s)) {
				res = true;
				i = empList.size();
			}
		}
		return res;
	}

	int getEmployeeIndex(String s) {
		int res = 0;
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getLastName().equals(s)) {
				res = i;
				i = empList.size();
			}
		}
		return res;
	}

	void removeEmployee(String s) {
		empList.remove(getEmployeeIndex(s));
	}

	boolean rightPassword(String pass) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for (int i = 0; i < pass.length(); i++) {
			if (Character.isUpperCase(pass.charAt(i))) {
				count1++;
			}
			if (Character.isLowerCase(pass.charAt(i))) {
				count2++;
			}
			if (Character.isDigit(pass.charAt(i))) {
				count3++;
			}
		}
		return count1 > 0 && count2 > 0 && count3 > 0;
	}

	boolean onlyDigits(String s) {
		boolean res = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				res = false;
				i = s.length();
			}
		}
		return res;
	}

	boolean onlyLetters(String s) {
		boolean res = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLetter(s.charAt(i))) {
				res = false;
				i = s.length();
			}
		}
		return res;
	}

	boolean rightAge(String s) {
		boolean res = false;
		if (Integer.parseInt(s) >= 16 && Integer.parseInt(s) <= 65) {
			res = true;
		}
		return res;
	}

	public static Comparator<Employee> NAME = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}

	};

	public static Comparator<Employee> AGE = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getAge() - e2.getAge();
		}

	};

	public static Comparator<Employee> SALARY = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return (int) (e1.getSalary() - e2.getSalary());
		}

	};
	
	void sortByName() {
		Collections.sort(empList, NAME);
	}
	
	void sortByAge() {
		Collections.sort(empList, AGE);
	}
	
	void sortBySalary() {
		Collections.sort(empList, SALARY);
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	// public static void main(String[] args) {
	// Solutions s = new Solutions();
	// System.out.println(s.rightAge("66"));
	// }
}
