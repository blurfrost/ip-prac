/**
 * Abstract base class for all commands in the Baby application.
 * Each command knows how to execute itself with the required dependencies.
 */
public abstract class Command {
    /**
     * Executes this command with the given dependencies.
     * 
     * @param taskList the list of tasks to operate on
     * @param ui the user interface for output
     * @param storage the storage for persistence
     * @throws Exception if an error occurs during execution
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws Exception;
    
    /**
     * Returns whether this command should exit the application.
     * 
     * @return true if this is an exit command, false otherwise
     */
    public boolean isExit() {
        return false;
    }
}
