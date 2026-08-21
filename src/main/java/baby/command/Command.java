package baby.command;

import baby.model.TaskList;
import baby.ui.Ui;
import baby.storage.Storage;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws Exception;
    
    public boolean isExit() {
        return false;
    }
}
