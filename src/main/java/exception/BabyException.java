package exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BabyException extends RuntimeException {
    protected final String errorCode;

    public BabyException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
