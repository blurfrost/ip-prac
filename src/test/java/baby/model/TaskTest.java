package baby.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskTest {
    
    @Test
    public void constructor_setsDescription() throws Exception {
        Task todo = new Todo("Read book");
        
        java.lang.reflect.Field descriptionField = Task.class.getDeclaredField("description");
        descriptionField.setAccessible(true);
        String description = (String) descriptionField.get(todo);
        
        assertEquals("Read book", description);
    }
    
    @Test
    public void constructor_initializesIsDoneToFalse() throws Exception {
        Task todo = new Todo("Read book");
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        boolean isDone = (Boolean) isDoneField.get(todo);
        
        assertEquals(false, isDone);
    }
    
    @Test
    public void getStatusIcon_returnsSpaceWhenNotDone() {
        Task todo = new Todo("Read book");
        assertEquals(" ", todo.getStatusIcon());
    }
    
    @Test
    public void getStatusIcon_returnsXWhenDone() {
        Task todo = new Todo("Read book");
        todo.markAsDone();
        assertEquals("X", todo.getStatusIcon());
    }
    
    @Test
    public void markAsDone_setsIsDoneToTrue() throws Exception {
        Task todo = new Todo("Read book");
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(false, (Boolean) isDoneField.get(todo));
        
        todo.markAsDone();
        
        assertEquals(true, (Boolean) isDoneField.get(todo));
    }
    
    @Test
    public void markAsUndone_setsIsDoneToFalse() throws Exception {
        Task todo = new Todo("Read book");
        
        todo.markAsDone();
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(true, (Boolean) isDoneField.get(todo));
        
        todo.markAsUndone();
        
        assertEquals(false, (Boolean) isDoneField.get(todo));
    }
    
    @Test
    public void getTypeIcon_returnsT() {
        Task todo = new Todo("Read book");
        assertEquals("[T]", todo.getTypeIcon());
    }
    
    @Test
    public void getExtraInfo_returnsEmptyString() {
        Task todo = new Todo("Read book");
        assertEquals("", todo.getExtraInfo());
    }
    
    @Test
    public void toString_format() {
        Task todo = new Todo("Read book");
        assertEquals("[T][ ] Read book", todo.toString());
    }
    
    @Test
    public void toString_formatWithDoneStatus() {
        Task todo = new Todo("Read book");
        todo.markAsDone();
        assertEquals("[T][X] Read book", todo.toString());
    }
}
