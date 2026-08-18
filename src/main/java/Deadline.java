public class Deadline extends Task {
    protected String dateInfo;
    
    public Deadline(String description, String dateInfo) {
        super(description);
        this.dateInfo = dateInfo;
    }
    
    @Override
    public String getTypeIcon() {
        return "[D]";
    }
    
    @Override
    public String getExtraInfo() {
        return " (" + dateInfo + ")";
    }
}
