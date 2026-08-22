package baby.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TodoTest {
    
    @Test
    public void constructor_setsDescription() throws Exception {
        Todo todo = new Todo("Read book");
        
        // Use reflection to access protected description field
        java.lang.reflect.Field descriptionField = Task.class.getDeclaredField("description");
        descriptionField.setAccessible(true);
        String description = (String) descriptionField.get(todo);
        
        assertEquals("Read book", description);
    }
    
    @Test
    public void constructor_initializesIsDoneToFalse() throws Exception {
        Todo todo = new Todo("Read book");
        
        // Use reflection to access protected isDone field
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        boolean isDone = (Boolean) isDoneField.get(todo);
        
        assertEquals(false, isDone);
    }
    
    @Test
    public void markAsDone_setsIsDoneToTrue() throws Exception {
        Todo todo = new Todo("Read book");
        
        // Verify initial state
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(false, (Boolean) isDoneField.get(todo));
        
        // Mark as done
        todo.markAsDone();
        
        // Verify state changed
        assertEquals(true, (Boolean) isDoneField.get(todo));
    }
    
    @Test
    public void markAsUndone_setsIsDoneToFalse() throws Exception {
        Todo todo = new Todo("Read book");
        
        // Mark as done first
        todo.markAsDone();
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(true, (Boolean) isDoneField.get(todo));
        
        // Mark as undone
        todo.markAsUndone();
        
        // Verify state changed back
        assertEquals(false, (Boolean) isDoneField.get(todo));
    }
    
    @Test
    public void getStatusIcon_returnsSpaceWhenNotDone() {
        Todo todo = new Todo("Read book");
        assertEquals(" ", todo.getStatusIcon());
    }
    
    @Test
    public void getStatusIcon_returnsXWhenDone() {
        Todo todo = new Todo("Read book");
        todo.markAsDone();
        assertEquals("X", todo.getStatusIcon());
    }
    
    @Test
    public void getTypeIcon_returnsT() {
        Todo todo = new Todo("Read book");
        assertEquals("[T]", todo.getTypeIcon());
    }
    
    @Test
    public void getExtraInfo_returnsEmptyString() {
        Todo todo = new Todo("Read book");
        assertEquals("", todo.getExtraInfo());
    }
    
    @Test
    public void toString_format() {
        Todo todo = new Todo("Read book");
        assertEquals("[T][ ] Read book", todo.toString());
    }
    
    @Test
    public void toString_formatWithDoneStatus() {
        Todo todo = new Todo("Read book");
        todo.markAsDone();
        assertEquals("[T][X] Read book", todo.toString());
    }
    
    @Test
    public void serialize_formatNotDone() {
        Todo todo = new Todo("Read book");
        assertEquals("T|false|Read book", todo.serialize());
    }
    
    @Test
    public void serialize_formatDone() {
        Todo todo = new Todo("Read book");
        todo.markAsDone();
        assertEquals("T|true|Read book", todo.serialize());
    }
    
    @Test
    public void constructor_setsDescriptionWithSpaces() throws Exception {
        Todo todo = new Todo("  Read book  ");
        
        java.lang.reflect.Field descriptionField = Task.class.getDeclaredField("description");
        descriptionField.setAccessible(true);
        String description = (String) descriptionField.get(todo);
        
        assertEquals("  Read book  ", description);
    }
    
    @Test
    public void constructor_setsEmptyDescription() throws Exception {
        Todo todo = new Todo("");
        
        java.lang.reflect.Field descriptionField = Task.class.getDeclaredField("description");
        descriptionField.setAccessible(true);
        String description = (String) descriptionField.get(todo);
        
        assertEquals("", description);
    }
}
