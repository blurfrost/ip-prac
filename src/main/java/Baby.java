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
            }
            System.out.println(input);
            System.out.println(separator);
        }
        
        scanner.close();
    }
}
