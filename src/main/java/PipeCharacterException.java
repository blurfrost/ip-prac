/**
 * Exception thrown when a pipe character is used in input.
 */
class PipeCharacterException extends BabyException {
    public static final String ERROR_CODE = "PIPE_CHARACTER";

    /**
     * Constructs a new PipeCharacterException.
     *
     * @param input the input that contains the pipe character
     */
    public PipeCharacterException(String input) {
        super("Input contains invalid character '|'.", ERROR_CODE);
    }
}
