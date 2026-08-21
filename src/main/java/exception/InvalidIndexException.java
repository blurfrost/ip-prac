package exception;

public class InvalidIndexException extends BabyException {
    public static final String ERROR_CODE = "INVALID_INDEX";

    public InvalidIndexException(int index, int maxIndex, int taskCount) {
        super("Invalid index: " + index + ". Valid range: 1-" + maxIndex + ". You have " + taskCount + " tasks.", ERROR_CODE);
    }

    public InvalidIndexException(String indexStr, int maxIndex, int taskCount) {
        super("Invalid index: " + indexStr + ". Valid range: 1-" + maxIndex + ". You have " + taskCount + " tasks.", ERROR_CODE);
    }
}
