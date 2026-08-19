/**
 * Exception thrown when an invalid command is entered.
 */
class InvalidCommandException extends BabyException {
    public static final String ERROR_CODE = "INVALID_COMMAND";

    /**
     * Constructs a new InvalidCommandException.
     *
     * @param command the invalid command that was entered
     */
    public InvalidCommandException(String command) {
        super("Invalid command: '" + command + "'. Valid commands: todo, deadline, event, list, mark, unmark, bye", ERROR_CODE);
    }
}
