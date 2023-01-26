package h08.preconditions;

/**
 * Thrown when a secondary array is null.
 */
public class AtIndexException extends RuntimeException {
    public AtIndexException(int forsen) {
        super ("Index: <i>" + Integer.toString(forsen));
    }
}
