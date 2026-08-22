package baby.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EventTest {
    
    @Test
    public void constructor_setsDescription() throws Exception {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        
        java.lang.reflect.Field descriptionField = Task.class.getDeclaredField("description");
        descriptionField.setAccessible(true);
        String description = (String) descriptionField.get(event);
        
        assertEquals("Meeting", description);
    }
    
    @Test
    public void constructor_setsStartDate() throws Exception {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        
        java.lang.reflect.Field startDateField = Event.class.getDeclaredField("startDate");
        startDateField.setAccessible(true);
        String startDate = (String) startDateField.get(event);
        
        assertEquals("Monday", startDate);
    }
    
    @Test
    public void constructor_setsEndDate() throws Exception {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        
        java.lang.reflect.Field endDateField = Event.class.getDeclaredField("endDate");
        endDateField.setAccessible(true);
        String endDate = (String) endDateField.get(event);
        
        assertEquals("Tuesday", endDate);
    }
    
    @Test
    public void constructor_initializesIsDoneToFalse() throws Exception {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        boolean isDone = (Boolean) isDoneField.get(event);
        
        assertEquals(false, isDone);
    }
    
    @Test
    public void markAsDone_setsIsDoneToTrue() throws Exception {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(false, (Boolean) isDoneField.get(event));
        
        event.markAsDone();
        
        assertEquals(true, (Boolean) isDoneField.get(event));
    }
    
    @Test
    public void markAsUndone_setsIsDoneToFalse() throws Exception {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        
        event.markAsDone();
        java.lang.reflect.Field isDoneField = Task.class.getDeclaredField("isDone");
        isDoneField.setAccessible(true);
        assertEquals(true, (Boolean) isDoneField.get(event));
        
        event.markAsUndone();
        
        assertEquals(false, (Boolean) isDoneField.get(event));
    }
    
    @Test
    public void getStatusIcon_returnsSpaceWhenNotDone() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        assertEquals(" ", event.getStatusIcon());
    }
    
    @Test
    public void getStatusIcon_returnsXWhenDone() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        event.markAsDone();
        assertEquals("X", event.getStatusIcon());
    }
    
    @Test
    public void getTypeIcon_returnsE() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        assertEquals("[E]", event.getTypeIcon());
    }
    
    @Test
    public void getExtraInfo_returnsFromToDate() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        assertEquals(" (from: Monday to: Tuesday)", event.getExtraInfo());
    }
    
    @Test
    public void toString_format() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        assertEquals("[E][ ] Meeting (from: Monday to: Tuesday)", event.toString());
    }
    
    @Test
    public void toString_formatWithDoneStatus() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        event.markAsDone();
        assertEquals("[E][X] Meeting (from: Monday to: Tuesday)", event.toString());
    }
    
    @Test
    public void serialize_formatNotDone() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        assertEquals("E|false|Meeting|Monday|Tuesday", event.serialize());
    }
    
    @Test
    public void serialize_formatDone() {
        Event event = new Event("Meeting", "Monday", "Tuesday");
        event.markAsDone();
        assertEquals("E|true|Meeting|Monday|Tuesday", event.serialize());
    }
}
