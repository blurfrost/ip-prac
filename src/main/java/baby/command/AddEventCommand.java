package baby.command;

import baby.model.Event;
import baby.storage.Storage;
import baby.ui.Ui;
import baby.model.TaskList;

public class AddEventCommand extends Command {
    private final String description;
    private final String startDate;
    private final String endDate;
    
    public AddEventCommand(String description, String startDate, String endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        taskList.add(new Event(description, startDate, endDate));
        storage.save(taskList.getAll());
        ui.showTaskAdded(taskList.get(taskList.size() - 1));
        ui.showTaskCount(taskList.size());
    }
}
