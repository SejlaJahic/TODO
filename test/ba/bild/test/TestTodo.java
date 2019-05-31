package ba.bild.test;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ba.bild.todo.Account;
import ba.bild.todo.Todo;

public class TestTodo {

	Todo todo;
	Date date;
	Account acc;
	ArrayList<Todo>todos;
	ArrayList<Todo>tag;
	
	@Before
	public void setUp() {
		date = new Date();
		acc = new Account("sejla","123");
		todos = new ArrayList<>();
		todos.add(todo);
		todo = new Todo(date,acc,"blabla");
		tag = new ArrayList<>();
		tag.add(todo);
	}
	
	@Test
	public void shouldReturnStringWhenMethodCall() {
		String string = "blabla";
		assertEquals(string, todo.getText());
	}
	
	@Test
	public void shouldSetStringWhenMethodCall() {
		String string = "blabla";
		todo.setText(string);
		assertEquals(todo.getText(),string);
	}
	
	@Test
	public void shouldReturnToStringWhenMethodCall() {
		String string = todo.toString();
		assertEquals(string, todo.toString());
	}
	
	@Test
	public void shouldSetAccountWhenMethodCall() {
		todo.setAcc(acc);
		String string = acc.toString();
		assertEquals(todo.getAcc().toString(), string);
	}
	
	@Test
	public void shouldSetDateWhenMethodCall() {
		todo.setDate(date);
		String string = date.toString();
		assertEquals(todo.getDate().toString(), string);
	}
	
	@Test
	public void shouldReturnDateWhenMethodCall() {
		assertEquals(todo.getDate().toString(),date.toString());
	}
	
	@Test
	public void shouldReturnAccountWhenMethodCall() {
		assertEquals(todo.getAcc().toString(), acc.toString());
	}
	
	@Test
	public void shouldReturnFalseWhenTagListIsNotEmpty() {
		assertEquals(false, tag.isEmpty());
	}
	
	@Test
	public void shouldShowTaggedTodoWhenMethodCall() {
		assertEquals(todo.toString(), tag.get(0).toString());
	}
	
	@Test
	public void shouldReturnTrueIfTagListIsEmpty() {
		tag.remove(tag.size()-1);
		assertEquals(true, tag.isEmpty());
	}
	
	
}
