import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Baby {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        TaskList taskList;
        try {
            taskList = new TaskList(storage.load());
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
            taskList = new TaskList();
        }
        String input;
        
        ui.printSeparator();
        ui.showBanner();
        ui.showGreeting();
        ui.printSeparator();
        
        outer: while (true) {
            try {
                if (!scanner.hasNextLine()) {
                    break;
                }
                input = StringUtils.trim(scanner.nextLine());
                ui.printSeparator();
                
                Parser.CommandResult result = Parser.parse(input);
                
                switch (result.getCommand()) {
                    case EXIT:
                        ui.showExitMessage();
                        ui.printSeparator();
                        storage.save(taskList.getAll());
                        break outer;
                        
                    case LIST:
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println(" " + (i + 1) + ". " + taskList.get(i).toString());
                        }
                        break;
                        
                    case USAGE_ONLY:
                        showUsageForCommand(input);
                        break;
                        
                    case ADD_TODO:
                        String todoDesc = result.getFirstArgument();
                        StringUtils.validateNoPipe(todoDesc);
                        taskList.add(new Todo(todoDesc));
                        storage.save(taskList.getAll());
                        ui.showTaskAdded(taskList.get(taskList.size() - 1));
                        ui.showTaskCount(taskList.size());
                        break;
                        
                    case ADD_DEADLINE:
                        List<String> deadlineArgs = result.getArguments();
                        taskList.add(new Deadline(deadlineArgs.get(0), deadlineArgs.get(1)));
                        storage.save(taskList.getAll());
                        ui.showTaskAdded(taskList.get(taskList.size() - 1));
                        ui.showTaskCount(taskList.size());
                        break;
                        
                    case ADD_EVENT:
                        List<String> eventArgs = result.getArguments();
                        taskList.add(new Event(eventArgs.get(0), eventArgs.get(1), eventArgs.get(2)));
                        storage.save(taskList.getAll());
                        ui.showTaskAdded(taskList.get(taskList.size() - 1));
                        ui.showTaskCount(taskList.size());
                        break;
                        
                    case MARK:
                        try {
                            String indexStr = result.getFirstArgument();
                            int index = Integer.parseInt(indexStr) - 1;
                            taskList.validateIndex(index);
                            taskList.markAsDone(index);
                            storage.save(taskList.getAll());
                            ui.showTaskMarked(taskList.get(index));
                        } catch (NumberFormatException e) {
                            throw new InvalidIndexException(result.getFirstArgument(), taskList.size(), taskList.size());
                        }
                        break;
                        
                    case UNMARK:
                        try {
                            String unmarkIndexStr = result.getFirstArgument();
                            int unmarkIndex = Integer.parseInt(unmarkIndexStr) - 1;
                            taskList.validateIndex(unmarkIndex);
                            taskList.markAsUndone(unmarkIndex);
                            storage.save(taskList.getAll());
                            ui.showTaskUnmarked(taskList.get(unmarkIndex));
                        } catch (NumberFormatException e) {
                            throw new InvalidIndexException(result.getFirstArgument(), taskList.size(), taskList.size());
                        }
                        break;
                        
                    case DELETE:
                        try {
                            String deleteIndexStr = result.getFirstArgument();
                            int deleteIndex = Integer.parseInt(deleteIndexStr) - 1;
                            taskList.validateIndex(deleteIndex);
                            ui.showTaskDeleted(taskList.get(deleteIndex));
                            taskList.remove(deleteIndex);
                            storage.save(taskList.getAll());
                            ui.showTaskCount(taskList.size());
                        } catch (NumberFormatException e) {
                            throw new InvalidIndexException(result.getFirstArgument(), taskList.size(), taskList.size());
                        }
                        break;
                        
                    case INVALID_COMMAND:
                        throw new InvalidCommandException(input);
                        
                    default:
                        throw new InvalidCommandException(input);
                }
            } catch (InvalidCommandException | InvalidTaskFormatException | TaskNotFoundException | InvalidIndexException | PipeCharacterException | IOException e) {
                System.out.println(e.getMessage());
            }
            ui.printSeparator();
        }
        
        scanner.close();
    }
    
    private static void showUsageForCommand(String input) {
        if (input.equals(TaskType.TODO.getCommandWord())) {
            System.out.println("A " + TaskType.TODO.getCommandWord() + " should include a description of the task. Example usage: " + TaskType.TODO.getUsageMessage());
        } else if (input.equals(TaskType.DEADLINE.getCommandWord())) {
            System.out.println("A " + TaskType.DEADLINE.getCommandWord() + " should include a description and a due date. Example usage: " + TaskType.DEADLINE.getUsageMessage());
        } else if (input.equals(TaskType.EVENT.getCommandWord())) {
            System.out.println("An " + TaskType.EVENT.getCommandWord() + " should include a description, a start date and end date. Example usage: " + TaskType.EVENT.getUsageMessage());
        } else if (input.equals("delete")) {
            System.out.println("A delete command should include a task number. Example usage: delete <task-number>");
        }
    }
}
