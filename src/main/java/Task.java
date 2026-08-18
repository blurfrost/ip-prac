public class Task {
    protected String description;
    protected boolean isDone;
    protected char type;
    protected String dateInfo;
    
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = 'T';
        this.dateInfo = null;
    }
    
    public Task(String description, char type, String dateInfo) {
        this.description = description;
        this.isDone = false;
        this.type = type;
        this.dateInfo = dateInfo;
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
    
    @Override
    public String toString() {
        String typeIcon = "[" + type + "]";
        if (dateInfo != null) {
            return typeIcon + "[" + getStatusIcon() + "] " + description + " (" + dateInfo + ")";
        }
        return typeIcon + "[" + getStatusIcon() + "] " + description;
    }
}
