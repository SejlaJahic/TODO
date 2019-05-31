package ba.bild.todo;

import java.util.ArrayList;

public class Account {

	protected String name;
	protected String password;
	public static ArrayList<Account> accounts = new ArrayList<>();
	
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", password=" + password + "]";
	}
	
	
	
}
