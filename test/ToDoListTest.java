//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ToDoListTest extends TestCase {
	private Task task1;
	private Task task2;
	private Task task3;
	private List<Task> taskList;

	private ToDoList todoList;

	public ToDoListTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		task1 = new Task("desc 1");
		task2 = new Task("desc 2");
		task3 = new Task("desc 3");

		todoList = new ToDoList();

		taskList = new ArrayList<Task>();
	}

	@After
	public void tearDown() throws Exception {
		task1 = null;
		task2 = null;
		task3 = null;

		todoList = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size());
		assertEquals(task1, todoList.getTask(task1.getDescription()));
	}

	@Test
	public void testgetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1));
		todoList.completeTask(task1);
		assertEquals(true, todoList.getStatus(task1));
	}

	@Test
	public void testRemoveTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.addTask(task2);
		;

		todoList.removeTask(task1);
		assertNull(todoList.getTask(task1.getDescription()));
	}

	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);

		Collection<Task> tasks = todoList.getCompletedTasks();
		assertEquals(2, tasks.size());
	}

	@Test
	public void testSearchTasks() {
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		Task task4 = new Task("desc 1");
		todoList.addTask(task4);
		Collection<Task> testList = todoList.searchTasks("desc 1");
		assertNotNull(testList);
		assertFalse(testList.isEmpty());
		assertEquals(2, testList.size());
		Iterator iter = testList.iterator();
		Task testTask = (Task) iter.next();
		assertEquals(task1, testTask);

	}
}
