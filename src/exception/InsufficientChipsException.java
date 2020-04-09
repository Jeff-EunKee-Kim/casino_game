package exception;

/**
 * @author Jeff Kim
 * started 4/9/20
 */
public class InsufficientChipsException extends RuntimeException{
    public InsufficientChipsException(String message) {
        super(message + "Chip is not sufficient");
    }

    public InsufficientChipsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientChipsException(Throwable cause) {
        super(cause);
    }
}
