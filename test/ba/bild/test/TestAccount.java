package ba.bild.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ba.bild.todo.Account;

public class TestAccount {

	Account acc;

	@Before
	public void setUp() {
		String name="sejla";
		String password="123";
		acc = new Account(name,password);
	}
	
	@Test
	public void shouldReturnNameWhenMethodIsCalled() {
		String name = "sejla";
		assertEquals("sejla",name);
	}
	
	@Test
	public void shouldSetNameWhenMethodIsCalled() {
		String name="sejla";
		acc.setName(name);
		assertEquals(acc.getName(),name );
	}
	
	@Test
	public void shouldReturnPasswordWhenMethodIsCalled() {
		String pass = "123";
		assertEquals("123", pass);
	}
	
	@Test
	public void shouldSetPasswordWhenMethodIsCalled() {
		String pass = "123";
		acc.setPassword(pass);
		assertEquals(acc.getPassword(), pass);
	}
	
	@Test
	public void shouldReturnStringOfObjectWhenMethodIsCalled() {
		String string = acc.toString();
		assertEquals(string,acc.toString());
	}
}
