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
        String[] items = new String[100];
        boolean[] done = new boolean[100];
        int count = 0;
        String input;
        
        System.out.println(separator);
        System.out.println(banner);
        System.out.println(greeting);
        System.out.println(separator);
        
        while (true) {
            input = scanner.nextLine();
            System.out.println(separator);
            if (input.equals("bye")) {
                System.out.println(farewell);
                System.out.println(separator);
                break;
            } else if (input.startsWith("list")) {
                for (int i = 0; i < count; i++) {
                    System.out.println(" " + (i + 1) + ". [" + (done[i] ? "X" : " ") + "] " + items[i]);
                }
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                if (index >= 0 && index < count) {
                    done[index] = true;
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  [X] " + items[index]);
                } else {
                    System.out.println("Task not found.");
                }
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                if (index >= 0 && index < count) {
                    done[index] = false;
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  [ ] " + items[index]);
                } else {
                    System.out.println("Task not found.");
                }
            } else {
                items[count] = input;
                done[count] = false;
                System.out.println("added: " + input);
                count++;
            }
            System.out.println(separator);
        }
        
        scanner.close();
    }
}
