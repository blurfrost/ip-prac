import java.util.ArrayList;
import java.util.List;

public class Parser {
    
    public enum Command {
        ADD_TODO,
        ADD_DEADLINE,
        ADD_EVENT,
        LIST,
        MARK,
        UNMARK,
        DELETE,
        EXIT,
        INVALID_COMMAND,
        USAGE_ONLY
    }
    
    public static class CommandResult {
        private final Command command;
        private final List<String> arguments;
        
        public CommandResult(Command command, List<String> arguments) {
            this.command = command;
            this.arguments = arguments != null ? arguments : new ArrayList<>();
        }
        
        public Command getCommand() {
            return command;
        }
        
        public List<String> getArguments() {
            return arguments;
        }
        
        public String getFirstArgument() {
            return arguments.isEmpty() ? null : arguments.get(0);
        }
    }
    
    public static CommandResult parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new CommandResult(Command.INVALID_COMMAND, null);
        }
        
        String trimmedInput = input.trim();
        
        if (trimmedInput.equals("bye")) {
            return new CommandResult(Command.EXIT, null);
        } else if (trimmedInput.equals("list")) {
            return new CommandResult(Command.LIST, null);
        } else if (input.equals(TaskType.TODO.getCommandWord())) {
            return new CommandResult(Command.USAGE_ONLY, null);
        } else if (input.startsWith(TaskType.TODO.getCommandWord() + " ")) {
            String description = StringUtils.normalizeWhitespace(input.substring(5));
            return new CommandResult(Command.ADD_TODO, List.of(description));
        } else if (input.equals(TaskType.DEADLINE.getCommandWord())) {
            return new CommandResult(Command.USAGE_ONLY, null);
        } else if (input.startsWith(TaskType.DEADLINE.getCommandWord() + " ")) {
            return parseDeadlineInput(input);
        } else if (input.equals(TaskType.EVENT.getCommandWord())) {
            return new CommandResult(Command.USAGE_ONLY, null);
        } else if (input.startsWith(TaskType.EVENT.getCommandWord() + " ")) {
            return parseEventInput(input);
        } else if (input.startsWith("mark ")) {
            String indexStr = StringUtils.normalizeWhitespace(input.substring(5));
            return new CommandResult(Command.MARK, List.of(indexStr));
        } else if (input.startsWith("unmark ")) {
            String indexStr = StringUtils.normalizeWhitespace(input.substring(7));
            return new CommandResult(Command.UNMARK, List.of(indexStr));
        } else if (input.equals("delete")) {
            return new CommandResult(Command.USAGE_ONLY, null);
        } else if (input.startsWith("delete ")) {
            String indexStr = StringUtils.normalizeWhitespace(input.substring(7));
            return new CommandResult(Command.DELETE, List.of(indexStr));
        } else {
            return new CommandResult(Command.INVALID_COMMAND, null);
        }
    }
    
    private static CommandResult parseDeadlineInput(String input) {
        String fullInput = StringUtils.normalizeWhitespace(input.substring(9));
        StringUtils.validateNoPipe(fullInput);
        int slashIndex = fullInput.indexOf(" /by ");
        if (slashIndex > 0) {
            String description = fullInput.substring(0, slashIndex);
            String dateInfo = fullInput.substring(slashIndex + 5);
            String parsedDate = DateParser.parseDate(dateInfo);
            return new CommandResult(Command.ADD_DEADLINE, List.of(description, parsedDate));
        } else {
            throw new InvalidTaskFormatException(TaskType.DEADLINE.getUsageMessage(), fullInput, "Example: deadline homework /by Sunday");
        }
    }
    
    private static CommandResult parseEventInput(String input) {
        String fullInput = StringUtils.normalizeWhitespace(input.substring(6));
        StringUtils.validateNoPipe(fullInput);
        int fromIndex = fullInput.indexOf(" /from ");
        int toIndex = fullInput.indexOf(" /to ");
        if (fromIndex > 0 && toIndex > fromIndex) {
            String description = fullInput.substring(0, fromIndex);
            String fromPart = fullInput.substring(fromIndex + 7, toIndex);
            String toPart = fullInput.substring(toIndex + 5);
            String parsedFrom = DateParser.parseDate(fromPart);
            String parsedTo = DateParser.parseDate(toPart);
            return new CommandResult(Command.ADD_EVENT, List.of(description, parsedFrom, parsedTo));
        } else {
            throw new InvalidTaskFormatException(TaskType.EVENT.getUsageMessage(), fullInput, "Example: event meeting /from Mon 2pm /to 4pm");
        }
    }
}
