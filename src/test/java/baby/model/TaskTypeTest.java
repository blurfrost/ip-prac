package baby.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskTypeTest {
    
    @Test
    public void getCommandWord_returnsTodo() {
        assertEquals("todo", TaskType.TODO.getCommandWord());
    }
    
    @Test
    public void getCommandWord_returnsDeadline() {
        assertEquals("deadline", TaskType.DEADLINE.getCommandWord());
    }
    
    @Test
    public void getCommandWord_returnsEvent() {
        assertEquals("event", TaskType.EVENT.getCommandWord());
    }
    
    @Test
    public void getIcon_returnsT() {
        assertEquals("[T]", TaskType.TODO.getIcon());
    }
    
    @Test
    public void getIcon_returnsD() {
        assertEquals("[D]", TaskType.DEADLINE.getIcon());
    }
    
    @Test
    public void getIcon_returnsE() {
        assertEquals("[E]", TaskType.EVENT.getIcon());
    }
    
    @Test
    public void getUsageMessage_returnsTodoFormat() {
        assertEquals("todo <description>", TaskType.TODO.getUsageMessage());
    }
    
    @Test
    public void findByCommandWord_returnsTodo() {
        assertEquals(TaskType.TODO, TaskType.findByCommandWord("todo"));
    }
    
    @Test
    public void findByCommandWord_returnsDeadline() {
        assertEquals(TaskType.DEADLINE, TaskType.findByCommandWord("deadline"));
    }
    
    @Test
    public void findByCommandWord_returnsEvent() {
        assertEquals(TaskType.EVENT, TaskType.findByCommandWord("event"));
    }
    
    @Test
    public void findByCommandWord_returnsNullForUnknown() {
        assertEquals(null, TaskType.findByCommandWord("unknown"));
    }
}
