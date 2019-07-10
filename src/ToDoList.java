import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoList {

	private List<Task> taskList = new ArrayList<Task>();

	public boolean addTask(Task task) {
		return taskList.add(task);
	}
	
	public boolean removeTask(int index) {
		return removeTask(taskList.get(index-1));
	}

	public boolean removeTask(Task task) {
		if(task != null) 
			return taskList.remove(task);
		else 
			return false;
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

	public Collection<Task> searchTasks(String description) {
		return taskList.stream().filter(
				obj -> obj != null && ((obj.getDescription() != null && obj.getDescription().contains(description))
						|| (obj.getCategory() != null && obj.getCategory().contains(description)
								|| (obj.getPriority() != null && obj.getPriority().contains(description))
								|| (obj.getTitle() != null && obj.getTitle().contains(description)))))
				.collect(Collectors.toList());
	}
}
