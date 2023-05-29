package businesslayer;

/**
 *
 * This class represents an exception that is thrown when data is not in a valid
 * format during validation. It extends the base Java Exception class.
 * Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 *
 */
public class ValidationException extends Exception {

    /**
     * Constructs a new ValidationException object with a default message "Data
     * not in valid format".
     */
    public ValidationException() {
        super("Data not in valid format");
    }

    /**
     * Constructs a new ValidationException object with the specified error
     * message.
     *
     * @param message The error message to include in the exception.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new ValidationException object with the specified error
     * message and cause.
     *
     * @param message The error message to include in the exception.
     * @param throwable The cause of the exception.
     */
    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a new ValidationException object with the specified cause.
     *
     * @param throwable The cause of the exception.
     */
    public ValidationException(Throwable throwable) {
        super(throwable);
    }
}
