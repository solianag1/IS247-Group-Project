


/**
 * A custom exception for invalid banking or budgeting operations,
 * such as attempting to withdraw or spend more than is available
 * or providing a non‐positive amount.
 */
public class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
