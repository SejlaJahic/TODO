package ba.bild.todo;

import java.util.ArrayList;
import java.util.Date;


public class Todo {

	protected Date date;
	protected Account acc;
	protected String text;
	public static ArrayList<Todo> todo = new ArrayList<>();
	public static ArrayList<Todo> todoTag = new ArrayList<>();

	public Todo(Date date, Account acc, String text) {
		this.date = date;
		this.acc = acc;
		this.text = text;
	}

	public static void showToEdit() {
		for (Todo e : todo) {
			System.out.println("index: " + todo.indexOf(e) + ". " + e);
		}
	}

	public static void showAllTodos() {
		if (todo.isEmpty()) {
			System.out.println("There is no todo's at the moment!");
		} else {
			for (int i = todo.size() - 1; i >= 0; i--) {
				System.out.println(todo.get(i));
			}
		}

	}

	public static void addTag(int indexOfTodo) {
		todoTag.add(todo.get(indexOfTodo));
		todo.remove(todo.get(indexOfTodo));

	}

	public static void showTaggedTodo() {
		if (todoTag.isEmpty()) {
			System.out.println("There is no tagged todo's!");
		} else {
			for (Todo e : todoTag) {
				System.out.println("XXXXXXXX " + e + " XXXXXXXX");
			}
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Todo [date=" + date + ", text=" + text + "]";
	}

}
