package baby.command;

import baby.storage.Storage;
import baby.ui.Ui;
import baby.model.TaskList;

public class MarkCommand extends Command {
    private final int index;
    
    public MarkCommand(int index) {
        this.index = index;
    }
    
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        taskList.validateIndex(index);
        taskList.markAsDone(index);
        storage.save(taskList.getAll());
        ui.showTaskMarked(taskList.get(index));
    }
}
