package exception;

public class UnloggedException extends RuntimeException{
    public UnloggedException() {
        super();
    }

    public UnloggedException(String message) {
        super(message);
    }

    public UnloggedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnloggedException(Throwable cause) {
        super(cause);
    }

    public UnloggedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
