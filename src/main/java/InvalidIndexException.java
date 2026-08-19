/**
 * Exception thrown when an invalid index (non-numeric or less than 1) is provided.
 */
class InvalidIndexException extends BabyException {
    public static final String ERROR_CODE = "INVALID_INDEX";

    /**
     * Constructs a new InvalidIndexException.
     *
     * @param index the invalid index value
     * @param maxIndex the maximum valid task index
     * @param taskCount the total number of tasks
     */
    public InvalidIndexException(int index, int maxIndex, int taskCount) {
        super("Invalid index: " + index + ". Valid range: 1-" + maxIndex + ". You have " + taskCount + " tasks.", ERROR_CODE);
    }

    /**
     * Constructs a new InvalidIndexException for non-numeric index values.
     *
     * @param indexStr the invalid index string
     * @param maxIndex the maximum valid task index
     * @param taskCount the total number of tasks
     */
    public InvalidIndexException(String indexStr, int maxIndex, int taskCount) {
        super("Invalid index: " + indexStr + ". Valid range: 1-" + maxIndex + ". You have " + taskCount + " tasks.", ERROR_CODE);
    }
}
