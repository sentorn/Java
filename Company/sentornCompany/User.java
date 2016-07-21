package com.sentornCompany;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{

	private String login;
	private String password;
	
	public User() {
		
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		User a = (User) obj;
		boolean c = this.login != null && this.login.equals(a.login) &&
				this.password != null && this.password.equals(a.password);
		return c;
	}
	
	public int hashCode() {
		int res = 1;
		res = res + (this.login != null ? this.login.hashCode() : 0);
		res = res + (this.password != null ? this.password.hashCode() : 0);
		return res;
	}
}
