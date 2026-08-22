package baby.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.InvalidIndexException;
import exception.TaskNotFoundException;

public class TaskListTest {
    
    @Test
    public void constructor_initializesEmpty() {
        TaskList taskList = new TaskList();
        assertEquals(0, taskList.size());
        assertNotNull(taskList.getAll());
    }
    
    @Test
    public void add_increasesSize() {
        TaskList taskList = new TaskList();
        taskList.add(new Todo("Task 1"));
        assertEquals(1, taskList.size());
    }
    
    @Test
    public void add_addsTask() {
        TaskList taskList = new TaskList();
        Todo todo = new Todo("Read book");
        taskList.add(todo);
        
        assertEquals(todo, taskList.get(0));
    }
    
    @Test
    public void get_returnsTask() {
        TaskList taskList = new TaskList();
        Todo todo = new Todo("Read book");
        taskList.add(todo);
        
        assertEquals(todo, taskList.get(0));
    }
    
    @Test
    public void remove_decreasesSize() {
        TaskList taskList = new TaskList();
        taskList.add(new Todo("Task 1"));
        taskList.add(new Todo("Task 2"));
        
        taskList.remove(0);
        assertEquals(1, taskList.size());
    }
    
    @Test
    public void size_returnsCount() {
        TaskList taskList = new TaskList();
        assertEquals(0, taskList.size());
        
        taskList.add(new Todo("Task 1"));
        assertEquals(1, taskList.size());
        
        taskList.add(new Todo("Task 2"));
        assertEquals(2, taskList.size());
    }
    
    @Test
    public void getAll_returnsCopy() {
        TaskList taskList = new TaskList();
        Todo todo = new Todo("Read book");
        taskList.add(todo);
        
        List<Task> all = taskList.getAll();
        assertEquals(1, all.size());
        assertEquals(todo, all.get(0));
    }
    
    @Test
    public void markAsDone_marksTask() throws Exception {
        TaskList taskList = new TaskList();
        Todo todo = new Todo("Read book");
        taskList.add(todo);
        
        taskList.markAsDone(0);
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(true, (Boolean) isDoneField.get(todo));
    }
    
    @Test
    public void markAsUndone_marksTask() throws Exception {
        TaskList taskList = new TaskList();
        Todo todo = new Todo("Read book");
        taskList.add(todo);
        todo.markAsDone();
        
        taskList.markAsUndone(0);
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(false, (Boolean) isDoneField.get(todo));
    }
    
    @Test
    public void validateIndex_throwsExceptionForNegative() {
        TaskList taskList = new TaskList();
        taskList.add(new Todo("Task 1"));
        
        assertThrows(InvalidIndexException.class, () -> {
            taskList.validateIndex(-1);
        });
    }
    
    @Test
    public void validateIndex_throwsExceptionForTooHigh() {
        TaskList taskList = new TaskList();
        taskList.add(new Todo("Task 1"));
        
        assertThrows(TaskNotFoundException.class, () -> {
            taskList.validateIndex(1);
        });
    }
    
    @Test
    public void constructor_withList_initializesTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Todo("Task 1"));
        tasks.add(new Todo("Task 2"));
        
        TaskList taskList = new TaskList(tasks);
        
        assertEquals(2, taskList.size());
    }
}
