package exception;

public class InvalidTaskFormatException extends BabyException {
    public static final String ERROR_CODE = "INVALID_FORMAT";

    public InvalidTaskFormatException(String expected, String input, String example) {
        super("Invalid format. Expected: " + expected + ". Input: " + input + ". " + example, ERROR_CODE);
    }
}
