package exception;

public class TaskNotFoundException extends BabyException {
    public static final String ERROR_CODE = "TASK_NOT_FOUND";

    public TaskNotFoundException(int index, int maxIndex, int taskCount) {
        super("Task " + index + " not found. Valid range: 1-" + maxIndex + ". You have " + taskCount + " tasks.", ERROR_CODE);
    }
}
