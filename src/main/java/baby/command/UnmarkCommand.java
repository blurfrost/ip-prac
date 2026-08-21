package baby.command;

import baby.storage.Storage;
import baby.ui.Ui;
import baby.model.TaskList;

public class UnmarkCommand extends Command {
    private final int index;
    
    public UnmarkCommand(int index) {
        this.index = index;
    }
    
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        taskList.validateIndex(index);
        taskList.markAsUndone(index);
        storage.save(taskList.getAll());
        ui.showTaskUnmarked(taskList.get(index));
    }
}
