import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> tasks;
    
    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    
    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }
    
    public void add(Task task) {
        tasks.add(task);
    }
    
    public Task get(int index) {
        return tasks.get(index);
    }
    
    public void remove(int index) {
        tasks.remove(index);
    }
    
    public int size() {
        return tasks.size();
    }
    
    public List<Task> getAll() {
        return new ArrayList<>(tasks);
    }
    
    public void markAsDone(int index) {
        tasks.get(index).markAsDone();
    }
    
    public void markAsUndone(int index) {
        tasks.get(index).markAsUndone();
    }
    
    public void validateIndex(int index) {
        if (index < 0) {
            throw new InvalidIndexException(index + 1, tasks.size(), tasks.size());
        }
        if (index >= tasks.size()) {
            throw new TaskNotFoundException(index + 1, tasks.size(), tasks.size());
        }
    }
}
