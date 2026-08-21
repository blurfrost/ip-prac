public class AddTodoCommand extends Command {
    private final String description;
    
    public AddTodoCommand(String description) {
        this.description = description;
    }
    
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        StringUtils.validateNoPipe(description);
        taskList.add(new Todo(description));
        storage.save(taskList.getAll());
        ui.showTaskAdded(taskList.get(taskList.size() - 1));
        ui.showTaskCount(taskList.size());
    }
}
