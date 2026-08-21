package baby.model;

public enum TaskType {
    TODO("todo", "[T]", "todo <description>"),
    
    DEADLINE("deadline", "[D]", "deadline <description> /by <date> (supports: dd MMM yyyy[ hhmm], dd/MM/yyyy[ hhmm], dd-MM-yyyy[ hhmm])"),
    
    EVENT("event", "[E]", "event <description> /from <date> /to <date> (supports: dd MMM yyyy[ hhmm], dd/MM/yyyy[ hhmm], dd-MM-yyyy[ hhmm])");
    
    private final String commandWord;
    private final String icon;
    private final String usageMessage;
    
    TaskType(String commandWord, String icon, String usageMessage) {
        this.commandWord = commandWord;
        this.icon = icon;
        this.usageMessage = usageMessage;
    }
    
    public String getCommandWord() {
        return commandWord;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public String getUsageMessage() {
        return usageMessage;
    }
    
    public static TaskType findByCommandWord(String commandWord) {
        for (TaskType type : TaskType.values()) {
            if (type.commandWord.equals(commandWord)) {
                return type;
            }
        }
        return null;
    }
}
