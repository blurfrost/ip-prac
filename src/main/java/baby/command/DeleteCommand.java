package baby.command;

import baby.storage.Storage;
import baby.ui.Ui;
import baby.model.TaskList;

public class DeleteCommand extends Command {
    private final int index;
    
    public DeleteCommand(int index) {
        this.index = index;
    }
    
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        taskList.validateIndex(index);
        ui.showTaskDeleted(taskList.get(index));
        taskList.remove(index);
        storage.save(taskList.getAll());
        ui.showTaskCount(taskList.size());
    }
}
