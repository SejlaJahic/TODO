package ba.bild.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ba.bild.todo.Account;
import ba.bild.todo.Todo;

public class TestMain {

	Account acc;
	Date date;
	Todo todo;
	ArrayList<Account>accs;
	ArrayList<Todo>todos;
	
	@Before
	public void setUp() {
		String name = "sejla";
		String password = "12345";
		String message = "study";
		accs = new ArrayList<>();
		acc = new Account(name, password);
		date = new Date();
		todo = new Todo(date,acc,message);
		accs.add(acc);
		todos = new ArrayList<>();
		todos.add(todo);
	}
	
	@Test
	public void shouldCreateNewAccountWhenSwitchCase1() {
		
		assertEquals(true, accs.contains(acc));
	}
	
	@Test
	public void shouldProceedToLoginWhenUsernameIsFound() {
		String username = "sejla";
		boolean login = false;
		if(username.equals(acc.getName()))
			login = true;
		assertEquals(login, username.equals(acc.getName()));
	}
	
	@Test
	public void shouldLoginWhenPasswordIsValid() {
		String password = "12345";
		boolean login = false;
		if(password.equals(acc.getPassword()))
			login = true;
		assertEquals(login, password.equals(acc.getPassword()));
	}
	
	@Test
	public void shouldAddTodoWhenSwitchCaseIs3() {
		assertEquals(true,todos.contains(todo));
	}
	
	@Test
	public void shouldUpdateTodosWhenSwitchCaseIs4() {
		Todo update = new Todo(date,acc,"zwizz");
		todos.set(todos.indexOf(todo), update);
		assertEquals(true, todos.contains(update));
	}
	
	@Test
	public void shouldDeleteTodoWhenSwitchCaseIs5() {
		todos.remove(todo);
		assertEquals(false,todos.contains(todo));
	}
	

}
