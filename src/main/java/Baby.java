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
        Task[] tasks = new Task[100];
        int count = 0;
        String input;
        
        System.out.println(separator);
        System.out.println(banner);
        System.out.println(greeting);
        System.out.println(separator);
        
        while (true) {
            if (!scanner.hasNextLine()) {
                break;
            }
            input = scanner.nextLine();
            System.out.println(separator);
            if (input.equals("bye")) {
                System.out.println(farewell);
                System.out.println(separator);
                break;
            } else if (input.startsWith("list")) {
                for (int i = 0; i < count; i++) {
                    System.out.println(" " + (i + 1) + ". " + tasks[i].toString());
                }
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                if (index >= 0 && index < count) {
                    tasks[index].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + tasks[index].toString());
                } else {
                    System.out.println("Task not found.");
                }
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                if (index >= 0 && index < count) {
                    tasks[index].markAsUndone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks[index].toString());
                } else {
                    System.out.println("Task not found.");
                }
            } else if (input.startsWith("todo ")) {
                String description = input.substring(5);
                tasks[count] = new Task(description, 'T', null);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[count].toString());
                count++;
                System.out.println("Now you have " + count + " tasks in the list.");
            } else if (input.startsWith("deadline ")) {
                String fullInput = input.substring(9);
                int slashIndex = fullInput.indexOf(" /by ");
                if (slashIndex > 0) {
                    String description = fullInput.substring(0, slashIndex);
                    String dateInfo = "by: " + fullInput.substring(slashIndex + 5);
                    tasks[count] = new Task(description, 'D', dateInfo);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + tasks[count].toString());
                    count++;
                    System.out.println("Now you have " + count + " tasks in the list.");
                } else {
                    System.out.println("Invalid deadline format. Use: deadline <description> /by <date>");
                }
            } else if (input.startsWith("event ")) {
                String fullInput = input.substring(6);
                int fromIndex = fullInput.indexOf(" /from ");
                int toIndex = fullInput.indexOf(" /to ");
                if (fromIndex > 0 && toIndex > fromIndex) {
                    String description = fullInput.substring(0, fromIndex);
                    String fromPart = "from: " + fullInput.substring(fromIndex + 7, toIndex);
                    String toPart = "to: " + fullInput.substring(toIndex + 5);
                    tasks[count] = new Task(description, 'E', fromPart + " " + toPart);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + tasks[count].toString());
                    count++;
                    System.out.println("Now you have " + count + " tasks in the list.");
                } else {
                    System.out.println("Invalid event format. Use: event <description> /from <start> /to <end>");
                }
            } else {
                System.out.println("Invalid task format. Please start with 'todo', 'deadline', or 'event'.");
                System.out.println("Available commands: todo, deadline, event, list, mark, unmark, bye");
            }
            System.out.println(separator);
        }
        
        scanner.close();
    }
}
