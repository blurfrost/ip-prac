public class Event extends Task {
    protected String dateInfo;
    
    public Event(String description, String dateInfo) {
        super(description);
        this.dateInfo = dateInfo;
    }
    
    @Override
    public String getTypeIcon() {
        return "[E]";
    }
    
    @Override
    public String getExtraInfo() {
        return " (" + dateInfo + ")";
    }
}
