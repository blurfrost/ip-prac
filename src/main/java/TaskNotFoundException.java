/**
 * Exception thrown when a task index is out of valid range.
 */
class TaskNotFoundException extends BabyException {
    public static final String ERROR_CODE = "TASK_NOT_FOUND";

    /**
     * Constructs a new TaskNotFoundException.
     *
     * @param index the task index that was requested
     * @param maxIndex the maximum valid task index
     * @param taskCount the total number of tasks
     */
    public TaskNotFoundException(int index, int maxIndex, int taskCount) {
        super("Task " + index + " not found. Valid range: 1-" + maxIndex + ". You have " + taskCount + " tasks.", ERROR_CODE);
    }
}
