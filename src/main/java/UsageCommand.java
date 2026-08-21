import java.util.List;

public class UsageCommand extends Command {
    private final String commandWord;
    
    public UsageCommand(String commandWord) {
        this.commandWord = commandWord;
    }
    
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        if (commandWord.equals(TaskType.TODO.getCommandWord())) {
            System.out.println("A " + commandWord + " should include a description of the task. Example usage: " + TaskType.TODO.getUsageMessage());
        } else if (commandWord.equals(TaskType.DEADLINE.getCommandWord())) {
            System.out.println("A " + commandWord + " should include a description and a due date. Example usage: " + TaskType.DEADLINE.getUsageMessage());
        } else if (commandWord.equals(TaskType.EVENT.getCommandWord())) {
            System.out.println("An " + commandWord + " should include a description, a start date and end date. Example usage: " + TaskType.EVENT.getUsageMessage());
        } else if (commandWord.equals("delete")) {
            System.out.println("A delete command should include a task number. Example usage: delete <task-number>");
        }
    }
}
