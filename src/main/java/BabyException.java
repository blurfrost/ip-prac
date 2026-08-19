/**
 * Base exception for all Baby application errors.
 * Extends RuntimeException for unchecked exception behavior.
 */
abstract class BabyException extends RuntimeException {
    protected final String errorCode;

    /**
     * Constructs a new BabyException with the specified message and error code.
     *
     * @param message the detail message explaining the error
     * @param errorCode the error code for programmatic identification
     */
    public BabyException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Returns the error code for this exception.
     *
     * @return the error code string
     */
    public String getErrorCode() {
        return errorCode;
    }
}
