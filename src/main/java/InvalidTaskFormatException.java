/**
 * Exception thrown when a task command has invalid format.
 */
class InvalidTaskFormatException extends BabyException {
    public static final String ERROR_CODE = "INVALID_FORMAT";

    /**
     * Constructs a new InvalidTaskFormatException.
     *
     * @param expected the expected format
     * @param input the actual input that was provided
     * @param example an example of correct usage
     */
    public InvalidTaskFormatException(String expected, String input, String example) {
        super("Invalid format. Expected: " + expected + ". Input: " + input + ". " + example, ERROR_CODE);
    }
}
