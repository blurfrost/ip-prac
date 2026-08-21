import java.util.ArrayList;
import java.util.List;

public class Ui {
    private static final String SEPARATOR = "____________________________________________________________";
    
    public void showBanner() {
        String banner = " ____    _    ____ __   __\n"
                + "| __ )  / \\  | __ )\\ \\ / /\n"
                + "|  _ \\ / _ \\ |  _ \\ \\ V /\n"
                + "| |_) / ___ \\| |_) | | |\n"
                + "|____/_/   \\_\\____/  |_|";
        System.out.println(banner);
    }
    
    public void showGreeting() {
        System.out.println();
        System.out.println("Hello! I'm Baby.");
        System.out.println("What can I do for you?");
    }
    
    public void showExitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }
    
    public void printSeparator() {
        System.out.println(SEPARATOR);
    }
    
    public void showTaskAdded(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
    }
    
    public void showTaskCount(int count) {
        System.out.println("Now you have " + count + " tasks in the list.");
    }
    
    public void showTaskMarked(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task.toString());
    }
    
    public void showTaskUnmarked(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task.toString());
    }
    
    public void showTaskDeleted(Task task) {
        System.out.println("OK, I've deleted this task:");
        System.out.println("  " + task.toString());
    }
    
    public void showTaskList(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + tasks.get(i).toString());
        }
    }
    
    public void showTodoUsage() {
        System.out.println("A todo should include a description of the task. Example usage: " + TaskType.TODO.getUsageMessage());
    }
    
    public void showDeadlineUsage() {
        System.out.println("A deadline should include a description and a due date. Example usage: " + TaskType.DEADLINE.getUsageMessage());
    }
    
    public void showEventUsage() {
        System.out.println("An event should include a description, a start date and end date. Example usage: " + TaskType.EVENT.getUsageMessage());
    }
    
    public void showDeleteUsage() {
        System.out.println("A delete command should include a task number. Example usage: delete <task-number>");
    }
}
