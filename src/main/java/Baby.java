import java.io.IOException;
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
        
        ui.printSeparator();
        ui.showBanner();
        ui.showGreeting();
        ui.printSeparator();
        
        boolean isExit = false;
        while (!isExit) {
            try {
                if (!scanner.hasNextLine()) {
                    break;
                }
                String fullCommand = StringUtils.trim(scanner.nextLine());
                ui.printSeparator();
                
                Command command = Parser.parse(fullCommand);
                command.execute(taskList, ui, storage);
                isExit = command.isExit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            ui.printSeparator();
        }
        
        scanner.close();
    }
}
