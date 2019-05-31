package ba.bild.todo;

import java.io.BufferedWriter;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.Scanner;

public class MainTestTodo {

	public static void main(String[] args) {

		Scanner skener = new Scanner(System.in);
		File file = new File("store.txt");
	
		try {
			if (!file.exists())
				file.createNewFile();
			
			BufferedWriter output = Files.newBufferedWriter(file.toPath());

			boolean loggedIn = false;
			int index = 0;
			int input = -1;

			while (input != 0) {
				System.out.println("WELCOME \n" + "\nPress 1 for new Account " + "\nPress 2 for login "
						+ "\nPress 3 to add TODO " + "\nPress 4 to edit TODO " + "\nPress 5 to delete TODO "
						+ "\nPress 6 to show TODO list " + "\nPress 7 to add tag on TODO " + "\nPress 8 to logout"
						+ "\nPress 0 to end program");
				input = skener.nextInt();

				switch (input) {
				case 1:
					output.write("ACCOUNT:");

					System.out.println("Enter your name:");
					String name = skener.next();
					System.out.println("Enter your password:");
					String password = skener.next();
					Account acc = new Account(name, password);

					Account.accounts.add(acc);
					System.out.println("You have successfully registered!");
					output.write(acc.toString());
					output.newLine();
					break;

				case 2:
					while (!loggedIn) {
						boolean proceed = false;
						System.out.println("Enter your name:");
						String username = skener.next();
						String userpassword = "";

						vanjska: for (int i = 0; i < Account.accounts.size(); i++) {
							if (Account.accounts.get(i).name.contentEquals(username)) {
								proceed = true;
								break vanjska;
							}
						}

						if (proceed) {
							System.out.println("Enter your password:");
							userpassword = skener.next();

							outer: for (int i = 0; i < Account.accounts.size(); i++) {
								if (Account.accounts.get(i).password.contentEquals(userpassword)) {
									index = i;
									loggedIn = true;
									break outer;
								}
							}
						} else {
							System.out.println("Your username is not correct!");
						}

						if (!loggedIn) {
							System.out.println("Your password is not correct!");
						} else {
							System.out.println("You have successfully logged in!");
						}
					}

					break;

				case 3:
					if (loggedIn) {
						output.write("TODO:");

						Date date = new Date();
						Account account = Account.accounts.get(index);
						skener.nextLine();
						System.out.println("Enter TODO:");
						String toDo = skener.nextLine();
						Todo todo1 = new Todo(date, account, toDo);
						Todo.todo.add(todo1);
						output.write(todo1.toString());
						output.newLine();
						System.out.println("You have successfully added new todo!");
					} else {
						System.out.println("Only logged in users can access this.");
					}
					break;

				case 4:
					if (loggedIn) {
						output.write("TODO UPDATE:");

						Date date = new Date();
						System.out.println("Here is a list of all todo's:");
						Todo.showToEdit();
						skener.nextLine();
						System.out.println("Please choose an index of todo you want to edit:");
						int indexEdit = skener.nextInt();
						System.out.println("Now type new todo message:");
						skener.nextLine();
						String message = skener.nextLine();

						Todo update = new Todo(date, Account.accounts.get(index), message);
						Todo.todo.set(indexEdit, update);
						System.out.println("You have successfully edited todo at index: " + indexEdit);
						output.write(update.toString());
						output.newLine();
					} else {
						System.out.println("Only logged in users can access this.");
					}
					break;
				case 5:
					if (loggedIn) {
						System.out.println("Here is a list of all todo's:");
						Todo.showToEdit();
						System.out.println("Please choose an index of todo you want to delete:");
						skener.nextLine();
						int indexDelete = skener.nextInt();

						Todo.todo.remove(indexDelete);
						System.out.println("You have successfully deleted todo at index:" + indexDelete);
					} else {
						System.out.println("Only logged in users can access this.");
					}
					break;
				case 6:
					if (loggedIn) {
						System.out.println("TODO:");
						skener.nextLine();
						Todo.showAllTodos();
						System.out.println("TAGGED TODO:");
						Todo.showTaggedTodo();

					} else {
						System.out.println("Only logged in users can access this.");
					}
					break;
				case 7:
					if (loggedIn) {
						System.out.println("Here is a list of all todo's:");
						Todo.showToEdit();
						System.out.println("Please choose an index of todo you want to tag:");
						skener.nextLine();
						int indexTag = skener.nextInt();

						Todo.addTag(indexTag);
						System.out.println("You have successfully tagged Todo at index: " + indexTag);
					} else {
						System.out.println("Only logged in users can access this.");
					}
					break;
				case 8:
					loggedIn = false;
					System.out.println("You have successfully logged out");
				}
			}
		output.close();
		} catch (Exception ex) {
			System.out.println("Something went wrong.");
		} finally {
			skener.close();
		}
	
	}
}
