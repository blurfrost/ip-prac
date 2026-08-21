package baby.command;

import baby.storage.Storage;
import baby.ui.Ui;
import baby.model.TaskList;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        ui.showExitMessage();
        storage.save(taskList.getAll());
    }
    
    @Override
    public boolean isExit() {
        return true;
    }
}
