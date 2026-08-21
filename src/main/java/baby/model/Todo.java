package baby.model;

public class Todo extends Task {
    
    public Todo(String description) {
        super(description);
    }
    
    @Override
    public String getTypeIcon() {
        return "[T]";
    }
    
    @Override
    public String getExtraInfo() {
        return "";
    }
    
    @Override
    public String serialize() {
        String done = isDone ? "true" : "false";
        return "T|" + done + "|" + description;
    }
}
