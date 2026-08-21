package exception;

public class PipeCharacterException extends BabyException {
    public static final String ERROR_CODE = "PIPE_CHARACTER";

    public PipeCharacterException(String input) {
        super("Input contains invalid character '|'.", ERROR_CODE);
    }
}
