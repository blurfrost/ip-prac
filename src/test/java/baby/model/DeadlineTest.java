package baby.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    
    @Test
    public void constructor_setsDescription() throws Exception {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        
        java.lang.reflect.Field descriptionField = Task.class.getDeclaredField("description");
        descriptionField.setAccessible(true);
        String description = (String) descriptionField.get(deadline);
        
        assertEquals("Submit report", description);
    }
    
    @Test
    public void constructor_setsDateInfo() throws Exception {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        
        java.lang.reflect.Field dateInfoField = Deadline.class.getDeclaredField("dateInfo");
        dateInfoField.setAccessible(true);
        String dateInfo = (String) dateInfoField.get(deadline);
        
        assertEquals("Sunday", dateInfo);
    }
    
    @Test
    public void constructor_initializesIsDoneToFalse() throws Exception {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        boolean isDone = (Boolean) isDoneField.get(deadline);
        
        assertEquals(false, isDone);
    }
    
    @Test
    public void markAsDone_setsIsDoneToTrue() throws Exception {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(false, (Boolean) isDoneField.get(deadline));
        
        deadline.markAsDone();
        
        assertEquals(true, (Boolean) isDoneField.get(deadline));
    }
    
    @Test
    public void markAsUndone_setsIsDoneToFalse() throws Exception {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        
        deadline.markAsDone();
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(true, (Boolean) isDoneField.get(deadline));
        
        deadline.markAsUndone();
        
        assertEquals(false, (Boolean) isDoneField.get(deadline));
    }
    
    @Test
    public void getStatusIcon_returnsSpaceWhenNotDone() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        assertEquals(" ", deadline.getStatusIcon());
    }
    
    @Test
    public void getStatusIcon_returnsXWhenDone() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        deadline.markAsDone();
        assertEquals("X", deadline.getStatusIcon());
    }
    
    @Test
    public void getTypeIcon_returnsD() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        assertEquals("[D]", deadline.getTypeIcon());
    }
    
    @Test
    public void getExtraInfo_returnsByDateInfo() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        assertEquals(" (by: Sunday)", deadline.getExtraInfo());
    }
    
    @Test
    public void toString_format() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        assertEquals("[D][ ] Submit report (by: Sunday)", deadline.toString());
    }
    
    @Test
    public void toString_formatWithDoneStatus() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        deadline.markAsDone();
        assertEquals("[D][X] Submit report (by: Sunday)", deadline.toString());
    }
    
    @Test
    public void serialize_formatNotDone() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        assertEquals("D|false|Submit report|Sunday", deadline.serialize());
    }
    
    @Test
    public void serialize_formatDone() {
        Deadline deadline = new Deadline("Submit report", "Sunday");
        deadline.markAsDone();
        assertEquals("D|true|Submit report|Sunday", deadline.serialize());
    }
}
