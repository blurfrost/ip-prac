package exception;

public class InvalidCommandException extends BabyException {
    public static final String ERROR_CODE = "INVALID_COMMAND";

    public InvalidCommandException(String command) {
        super("Invalid command: '" + command + "'. Valid commands: todo, deadline, event, list, mark, unmark, bye", ERROR_CODE);
    }
}
