import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baby {
    public static void main(String[] args) {
        String banner = " ____    _    ____ __   __\n"
                + "| __ )  / \\  | __ )\\ \\ / /\n"
                + "|  _ \\ / _ \\ |  _ \\ \\ V /\n"
                + "| |_) / ___ \\| |_) | | |\n"
                + "|____/_/   \\_\\____/  |_|\n";
        String separator = "____________________________________________________________";
        String greeting = "Hello! I'm Baby.\nWhat can I do for you?";
        String farewell = "Bye. Hope to see you again soon!";
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        String input;
        
        System.out.println(separator);
        System.out.println(banner);
        System.out.println(greeting);
        System.out.println(separator);
        
        while (true) {
            try {
                if (!scanner.hasNextLine()) {
                    break;
                }
                input = StringUtils.trim(scanner.nextLine());
                System.out.println(separator);
                if (input.equals("bye")) {
                    System.out.println(farewell);
                    System.out.println(separator);
                    break;
                } else if (input.equals("list")) {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(" " + (i + 1) + ". " + tasks.get(i).toString());
                    }
                } else if (input.equals("todo")) {
                    System.out.println("A todo should include a description of the task. Example usage: todo <description>");
                } else if (input.startsWith("todo ")) {
                    String description = StringUtils.normalizeWhitespace(input.substring(5));
                    tasks.add(new Todo(description));
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + tasks.get(tasks.size() - 1).toString());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                } else if (input.equals("deadline")) {
                    System.out.println("A deadline should include a description and a due date. Example usage: deadline <description> /by <date>");
                } else if (input.startsWith("deadline ")) {
                    String fullInput = StringUtils.normalizeWhitespace(input.substring(9));
                    int slashIndex = fullInput.indexOf(" /by ");
                    if (slashIndex > 0) {
                        String description = fullInput.substring(0, slashIndex);
                        String dateInfo = "by: " + fullInput.substring(slashIndex + 5);
                        tasks.add(new Deadline(description, dateInfo));
                        System.out.println("Got it. I've added this task:");
                        System.out.println("  " + tasks.get(tasks.size() - 1).toString());
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } else {
                        throw new InvalidTaskFormatException("deadline <description> /by <date>", fullInput, "Example: deadline homework /by Sunday");
                    }
                } else if (input.equals("event")) {
                    System.out.println("An event should include a description, a start date and end date. Example usage: event <description> /from <start-date> /to <end-date>");
                } else if (input.startsWith("event ")) {
                    String fullInput = StringUtils.normalizeWhitespace(input.substring(6));
                    int fromIndex = fullInput.indexOf(" /from ");
                    int toIndex = fullInput.indexOf(" /to ");
                    if (fromIndex > 0 && toIndex > fromIndex) {
                        String description = fullInput.substring(0, fromIndex);
                        String fromPart = "from: " + fullInput.substring(fromIndex + 7, toIndex);
                        String toPart = "to: " + fullInput.substring(toIndex + 5);
                        String dateInfo = fromPart + " " + toPart;
                        tasks.add(new Event(description, dateInfo));
                        System.out.println("Got it. I've added this task:");
                        System.out.println("  " + tasks.get(tasks.size() - 1).toString());
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } else {
                        throw new InvalidTaskFormatException("event <description> /from <start> /to <end>", fullInput, "Example: event meeting /from Mon 2pm /to 4pm");
                    }
                } else if (input.startsWith("mark ")) {
                    String indexStr = StringUtils.normalizeWhitespace(input.substring(5));
                    try {
                        int index = Integer.parseInt(indexStr) - 1;
                        if (index < 0) {
                            throw new InvalidIndexException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                        }
                        if (index >= tasks.size()) {
                            throw new TaskNotFoundException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                        }
                        tasks.get(index).markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  " + tasks.get(index).toString());
                    } catch (NumberFormatException e) {
                        throw new InvalidIndexException(indexStr, tasks.size(), tasks.size());
                    }
                } else if (input.startsWith("unmark ")) {
                    String indexStr = StringUtils.normalizeWhitespace(input.substring(7));
                    try {
                        int index = Integer.parseInt(indexStr) - 1;
                        if (index < 0) {
                            throw new InvalidIndexException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                        }
                        if (index >= tasks.size()) {
                            throw new TaskNotFoundException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                        }
                        tasks.get(index).markAsUndone();
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println("  " + tasks.get(index).toString());
                    } catch (NumberFormatException e) {
                        throw new InvalidIndexException(indexStr, tasks.size(), tasks.size());
                    }
                } else if (input.equals("delete")) {
                    System.out.println("A delete command should include a task number. Example usage: delete <task-number>");
                } else if (input.startsWith("delete ")) {
                    String indexStr = StringUtils.normalizeWhitespace(input.substring(7));
                    try {
                        int index = Integer.parseInt(indexStr) - 1;
                        if (index < 0) {
                            throw new InvalidIndexException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                        }
                        if (index >= tasks.size()) {
                            throw new TaskNotFoundException(Integer.parseInt(indexStr), tasks.size(), tasks.size());
                        }
                        System.out.println("OK, I've deleted this task:");
                        System.out.println("  " + tasks.get(index).toString());
                        tasks.remove(index);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } catch (NumberFormatException e) {
                        throw new InvalidIndexException(indexStr, tasks.size(), tasks.size());
                    }
                } else {
                    throw new InvalidCommandException(input);
                }
            } catch (InvalidCommandException | InvalidTaskFormatException | TaskNotFoundException | InvalidIndexException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(separator);
        }
        
        scanner.close();
    }
}
