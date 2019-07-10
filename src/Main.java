import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to WOW Todo List, please e to continue...");
		String ePressed = input.next();
		if (ePressed.equals("e") || ePressed.equals("E")) {
			int userInp = 999;
			displayMenu(toDoList);
			while (userInp != 4) {
				performAction(input.nextInt(), toDoList, input);
			}
			System.out.println("Thank you!!");
			input.close();
		}
	}

	public static void displayMenu(ToDoList list) {
		int index = 0;
		// header
		System.out.println("**********************************************************");
		System.out.println("**                     Wow Todo List                    **");
		System.out.println("**********************************************************");

		// body
		System.out.println("*********************  Current Tasks  *******************");
		if (list.getAllTasks().size() > 0) {
			for (Task task : list.getAllTasks()) {
				System.out.println("");
				System.out.println(" S/N         : " + String.valueOf(index + 1));
				System.out.println(" title       : " + task.getTitle());
				System.out.println(" description : " + task.getDescription());
				System.out.println(" category    : " + task.getCategory());
				System.out.println(" priority    : " + task.getPriority());
				String status = task.isComplete() ? "completed" : "pending";
				System.out.println(" status      : " + status);
				System.out.println("");
				index++;
			}
		} else {
			System.out.println("");
			System.out.println("");
			System.out.println("                   EMPTY TODO LIST                    ");
			System.out.println("");
			System.out.println("");
		}
		// action
		System.out.println("**********************************************************");
		System.out.println("Choose your action  **************************************");
		System.out.println("1. Add New Task  2. Remove Task  3. Search Task  4. Exit  ");
		System.out.println("**********************************************************");
		System.out.print("Your action: ");
	}

	public static void performAction(int action, ToDoList list, Scanner scanner) {
//		Scanner scanner = new Scanner(System.in);
		switch (action) {
		case 1:
			System.out.println("Title (Your task title): ");
			String title = scanner.next();
			System.out.println("Description (Your task description): ");
			String desc = scanner.next();
			System.out.println("Category (Your task category): ");
			String category = scanner.next();
			System.out.println("Priority (1, 2, 3, ...): ");
			String priority = scanner.next();

			Task task = new Task();
			task.setTitle(title);
			task.setDescription(desc);
			task.setCategory(category);
			task.setPriority(priority);
			task.setComplete(false);

			list.addTask(task);
			System.out.println("SUCCESSFULLY CREATED A TASK!");
			displayMenu(list);
			break;
		case 2:
			System.out.print("Please enter the task number (S/N) to remove:");
			int index = scanner.nextInt();
			Boolean deleted = list.removeTask(index);
			if(deleted) {
				System.out.println("");
				System.out.println("SUCCESSFULLY DELETED A TASK!");
				System.out.println("");
			} else {
				System.out.println("");
				System.out.println("FAILED TO DELETE A TASK!");
				System.out.println("");
			}
			displayMenu(list);
			break;
		case 3:
			System.out.print("Please search :");
			break;
		case 4:
			System.out.println("");
			System.out.println("BYE BYE, SEE YOU AGAIN.");
			System.exit(0);
			break;
		default:
			System.out.println("");
			System.out.println("INVALID ACTION, PLEASE CHOOSE AGAIN.");
			System.out.println("");
			displayMenu(list);
			break;
		}
	}
}
