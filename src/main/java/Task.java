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
    
    /**
     * Serializes the task to a pipe-delimited format for file storage.
     * Each subclass must implement this to provide its specific format.
     *
     * @return the serialized task string
     */
    public abstract String serialize();
    
    @Override
    public String toString() {
        return getTypeIcon() + "[" + getStatusIcon() + "] " + description + getExtraInfo();
    }
}
