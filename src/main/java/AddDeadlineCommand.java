public class AddDeadlineCommand extends Command {
    private final String description;
    private final String dateInfo;
    
    public AddDeadlineCommand(String description, String dateInfo) {
        this.description = description;
        this.dateInfo = dateInfo;
    }
    
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        taskList.add(new Deadline(description, dateInfo));
        storage.save(taskList.getAll());
        ui.showTaskAdded(taskList.get(taskList.size() - 1));
        ui.showTaskCount(taskList.size());
    }
}
