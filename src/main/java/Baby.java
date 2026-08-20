import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baby {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks;
        try {
            tasks = storage.load();
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
            tasks = new ArrayList<>();
        }
        String input;
        
        ui.printSeparator();
        ui.showBanner();
        ui.showGreeting();
        ui.printSeparator();
        
        while (true) {
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
                        storage.save(tasks);
                        break;
                        
                    case LIST:
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(" " + (i + 1) + ". " + tasks.get(i).toString());
                        }
                        break;
                        
                    case USAGE_ONLY:
                        showUsageForCommand(input);
                        break;
                        
                    case ADD_TODO:
                        String todoDesc = result.getFirstArgument();
                        StringUtils.validateNoPipe(todoDesc);
                        tasks.add(new Todo(todoDesc));
                        storage.save(tasks);
                        ui.showTaskAdded(tasks.get(tasks.size() - 1));
                        ui.showTaskCount(tasks.size());
                        break;
                        
                    case ADD_DEADLINE:
                        List<String> deadlineArgs = result.getArguments();
                        tasks.add(new Deadline(deadlineArgs.get(0), deadlineArgs.get(1)));
                        storage.save(tasks);
                        ui.showTaskAdded(tasks.get(tasks.size() - 1));
                        ui.showTaskCount(tasks.size());
                        break;
                        
                    case ADD_EVENT:
                        List<String> eventArgs = result.getArguments();
                        tasks.add(new Event(eventArgs.get(0), eventArgs.get(1), eventArgs.get(2)));
                        storage.save(tasks);
                        ui.showTaskAdded(tasks.get(tasks.size() - 1));
                        ui.showTaskCount(tasks.size());
                        break;
                        
                    case MARK:
                        try {
                            String indexStr = result.getFirstArgument();
                            int index = Integer.parseInt(indexStr) - 1;
                            if (index < 0) {
                                throw new InvalidIndexException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                            }
                            if (index >= tasks.size()) {
                                throw new TaskNotFoundException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                            }
                            tasks.get(index).markAsDone();
                            storage.save(tasks);
                            ui.showTaskMarked(tasks.get(index));
                        } catch (NumberFormatException e) {
                            throw new InvalidIndexException(result.getFirstArgument(), tasks.size(), tasks.size());
                        }
                        break;
                        
                    case UNMARK:
                        try {
                            String unmarkIndexStr = result.getFirstArgument();
                            int unmarkIndex = Integer.parseInt(unmarkIndexStr) - 1;
                            if (unmarkIndex < 0) {
                                throw new InvalidIndexException(Integer.parseInt(unmarkIndexStr), tasks.size(), tasks.size());
                            }
                            if (unmarkIndex >= tasks.size()) {
                                throw new TaskNotFoundException(Integer.parseInt(unmarkIndexStr), tasks.size(), tasks.size());
                            }
                            tasks.get(unmarkIndex).markAsUndone();
                            storage.save(tasks);
                            ui.showTaskUnmarked(tasks.get(unmarkIndex));
                        } catch (NumberFormatException e) {
                            throw new InvalidIndexException(result.getFirstArgument(), tasks.size(), tasks.size());
                        }
                        break;
                        
                    case DELETE:
                        try {
                            String deleteIndexStr = result.getFirstArgument();
                            int deleteIndex = Integer.parseInt(deleteIndexStr) - 1;
                            if (deleteIndex < 0) {
                                throw new InvalidIndexException(Integer.parseInt(deleteIndexStr), tasks.size(), tasks.size());
                            }
                            if (deleteIndex >= tasks.size()) {
                                throw new TaskNotFoundException(Integer.parseInt(deleteIndexStr), tasks.size(), tasks.size());
                            }
                            ui.showTaskDeleted(tasks.get(deleteIndex));
                            tasks.remove(deleteIndex);
                            storage.save(tasks);
                            ui.showTaskCount(tasks.size());
                        } catch (NumberFormatException e) {
                            throw new InvalidIndexException(result.getFirstArgument(), tasks.size(), tasks.size());
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
