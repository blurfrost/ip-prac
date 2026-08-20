import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_PATH = "./data/baby.txt";
    
    /**
     * Saves the list of tasks to the data file.
     *
     * @param tasks the list of tasks to save
     * @throws IOException if an I/O error occurs
     */
    public void save(List<Task> tasks) throws IOException {
        Path dir = Paths.get("./data");
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        
        StringBuilder content = new StringBuilder();
        for (Task task : tasks) {
            content.append(task.serialize()).append("\n");
        }
        Files.write(Paths.get(FILE_PATH), content.toString().getBytes());
    }
    
    /**
     * Loads tasks from the data file.
     *
     * @return list of loaded tasks, or empty list if file doesn't exist or is corrupted
     * @throws IOException if an I/O error occurs
     */
    public List<Task> load() throws IOException {
        List<Task> tasks = new ArrayList<>();
        
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            return tasks;
        }
        
        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            Task task = parseTask(line);
            if (task != null) {
                tasks.add(task);
            } else if (!line.trim().isEmpty()) {
                System.err.println("Warning: Skipping corrupted line " + (i + 1) + ": " + line);
            }
        }
        
        return tasks;
    }
    
    /**
     * Parses a serialized task string back into a Task object.
     *
     * @param line the serialized task string
     * @return the parsed Task object, or null if parsing fails
     */
    private Task parseTask(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }
        
        String[] parts = line.split("\\|", 4);
        if (parts.length < 3) {
            return null;
        }
        
        String type = parts[0];
        boolean isDone = parts[1].equals("true");
        String description = parts[2];
        String extra = parts.length > 3 ? parts[3] : "";
        
        try {
            switch (type) {
                case "T":
                    Task todo = new Todo(description);
                    if (isDone) {
                        todo.markAsDone();
                    }
                    return todo;
                case "D":
                    Deadline deadline = extra.isEmpty()
                        ? new Deadline(description, "unknown")
                        : new Deadline(description, extra);
                    if (isDone) {
                        deadline.markAsDone();
                    }
                    return deadline;
                case "E":
                    Event event;
                    if (extra.isEmpty()) {
                        event = new Event(description, "unknown", "unknown");
                    } else {
                        String[] dateParts = extra.split("\\|", 2);
                        if (dateParts.length == 2) {
                            event = new Event(description, dateParts[0], dateParts[1]);
                        } else {
                            event = new Event(description, extra, "unknown");
                        }
                    }
                    if (isDone) {
                        event.markAsDone();
                    }
                    return event;
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
