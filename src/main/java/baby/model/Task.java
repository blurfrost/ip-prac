package baby.model;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }
    
    public void markAsDone() {
        isDone = true;
    }
    
    public void markAsUndone() {
        isDone = false;
    }
    
    public String getTypeIcon() {
        return "[T]";
    }
    
    public String getExtraInfo() {
        return "";
    }
    
    public abstract String serialize();
    
    @Override
    public String toString() {
        return getTypeIcon() + "[" + getStatusIcon() + "] " + description + getExtraInfo();
    }
}
