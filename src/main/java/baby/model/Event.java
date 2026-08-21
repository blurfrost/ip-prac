package baby.model;

public class Event extends Task {
    protected String startDate;
    protected String endDate;
    
    public Event(String description, String startDate, String endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    @Override
    public String getTypeIcon() {
        return "[E]";
    }
    
    @Override
    public String getExtraInfo() {
        return " (from: " + startDate + " to: " + endDate + ")";
    }
    
    @Override
    public String serialize() {
        String done = isDone ? "true" : "false";
        return "E|" + done + "|" + description + "|" + startDate + "|" + endDate;
    }
}
