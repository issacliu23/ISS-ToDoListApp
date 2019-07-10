import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ToDoList {

//	private HashMap<String, Task> tasks = new HashMap<String, Task>();
	private List<Task> taskList = new ArrayList<Task>();

	public static void main(String[] args) {

	}

	public boolean addTask(Task task) {
		return taskList.add(task);
	}

	public boolean removeTask(Task task) {
		return taskList.remove(task);
	}

	public void completeTask(Task task) {
		task.setComplete(true);
	}

	public boolean getStatus(Task task) {
		return task.isComplete();
	}

	public Task getTask(String description) {
		for (Task task : taskList) {
			if (task.getDescription().equals(description)) {
				return task;
			}
		}
		return null;
	}

	public List<Task> getAllTasks() {
		return taskList;
	}

	public Collection<Task> getCompletedTasks() {
		Collection<Task> completedTasks = new ArrayList<Task>();
		Collection<Task> allTasks = new ArrayList<Task>();
		allTasks = getAllTasks();
		for (Task task : allTasks)
			if (task.isComplete() == true)
				completedTasks.add(task);
		return completedTasks;
	}
}
