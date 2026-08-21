import java.util.ArrayList;
import java.util.List;

public class Parser {
    
    public static Command parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidCommandException(input);
        }
        
        String trimmedInput = input.trim();
        
        if (trimmedInput.equals("bye")) {
            return new ExitCommand();
        } else if (trimmedInput.equals("list")) {
            return new ListCommand();
        } else if (input.equals(TaskType.TODO.getCommandWord())) {
            return new UsageCommand(TaskType.TODO.getCommandWord());
        } else if (input.startsWith(TaskType.TODO.getCommandWord() + " ")) {
            String description = StringUtils.normalizeWhitespace(input.substring(5));
            return new AddTodoCommand(description);
        } else if (input.equals(TaskType.DEADLINE.getCommandWord())) {
            return new UsageCommand(TaskType.DEADLINE.getCommandWord());
        } else if (input.startsWith(TaskType.DEADLINE.getCommandWord() + " ")) {
            return parseDeadlineInput(input);
        } else if (input.equals(TaskType.EVENT.getCommandWord())) {
            return new UsageCommand(TaskType.EVENT.getCommandWord());
        } else if (input.startsWith(TaskType.EVENT.getCommandWord() + " ")) {
            return parseEventInput(input);
        } else if (input.startsWith("mark ")) {
            String indexStr = StringUtils.normalizeWhitespace(input.substring(5));
            int index;
            try {
                index = Integer.parseInt(indexStr) - 1;
            } catch (NumberFormatException e) {
                throw new InvalidIndexException(indexStr, 1, 1);
            }
            return new MarkCommand(index);
        } else if (input.startsWith("unmark ")) {
            String indexStr = StringUtils.normalizeWhitespace(input.substring(7));
            int index;
            try {
                index = Integer.parseInt(indexStr) - 1;
            } catch (NumberFormatException e) {
                throw new InvalidIndexException(indexStr, 1, 1);
            }
            return new UnmarkCommand(index);
        } else if (input.equals("delete")) {
            return new UsageCommand("delete");
        } else if (input.startsWith("delete ")) {
            String indexStr = StringUtils.normalizeWhitespace(input.substring(7));
            int index;
            try {
                index = Integer.parseInt(indexStr) - 1;
            } catch (NumberFormatException e) {
                throw new InvalidIndexException(indexStr, 1, 1);
            }
            return new DeleteCommand(index);
        } else {
            throw new InvalidCommandException(input);
        }
    }
    
    private static AddDeadlineCommand parseDeadlineInput(String input) {
        String fullInput = StringUtils.normalizeWhitespace(input.substring(9));
        StringUtils.validateNoPipe(fullInput);
        int slashIndex = fullInput.indexOf(" /by ");
        if (slashIndex > 0) {
            String description = fullInput.substring(0, slashIndex);
            String dateInfo = fullInput.substring(slashIndex + 5);
            String parsedDate = DateParser.parseDate(dateInfo);
            return new AddDeadlineCommand(description, parsedDate);
        } else {
            throw new InvalidTaskFormatException(TaskType.DEADLINE.getUsageMessage(), fullInput, "Example: deadline homework /by Sunday");
        }
    }
    
    private static AddEventCommand parseEventInput(String input) {
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
            return new AddEventCommand(description, parsedFrom, parsedTo);
        } else {
            throw new InvalidTaskFormatException(TaskType.EVENT.getUsageMessage(), fullInput, "Example: event meeting /from Mon 2pm /to 4pm");
        }
    }
}
