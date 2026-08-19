/**
 * Represents the different types of tasks that can be created in the Baby application.
 * Each task type defines its command word, display icon, and expected usage format.
 */
public enum TaskType {
    /** A simple todo task */
    TODO("todo", "[T]", "todo <description>"),
    
    /** A task with a deadline */
    DEADLINE("deadline", "[D]", "deadline <description> /by <date>"),
    
    /** A task with start and end times */
    EVENT("event", "[E]", "event <description> /from <start-date> /to <end-date>");
    
    private final String commandWord;
    private final String icon;
    private final String usageMessage;
    
    /**
     * Constructs a new TaskType with its properties.
     *
     * @param commandWord the command word used in input (e.g., "todo", "deadline", "event")
     * @param icon the icon used to display this task type
     * @param usageMessage the usage message for error display
     */
    TaskType(String commandWord, String icon, String usageMessage) {
        this.commandWord = commandWord;
        this.icon = icon;
        this.usageMessage = usageMessage;
    }
    
    /**
     * Returns the command word for this task type.
     *
     * @return the command word string
     */
    public String getCommandWord() {
        return commandWord;
    }
    
    /**
     * Returns the display icon for this task type.
     *
     * @return the icon string
     */
    public String getIcon() {
        return icon;
    }
    
    /**
     * Returns the usage message for this task type.
     *
     * @return the usage message string
     */
    public String getUsageMessage() {
        return usageMessage;
    }
    
    /**
     * Finds and returns the TaskType for the given command word.
     *
     * @param commandWord the command word to search for
     * @return the matching TaskType, or null if not found
     */
    public static TaskType findByCommandWord(String commandWord) {
        for (TaskType type : TaskType.values()) {
            if (type.commandWord.equals(commandWord)) {
                return type;
            }
        }
        return null;
    }
}
