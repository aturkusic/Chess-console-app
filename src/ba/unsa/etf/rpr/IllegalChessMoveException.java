package ba.unsa.etf.rpr;

public class IllegalChessMoveException extends Exception {
    public IllegalChessMoveException() { super(); }
    public IllegalChessMoveException(String message) { super(message); }
    public IllegalChessMoveException(String message, Throwable cause) { super(message, cause); }
    public IllegalChessMoveException(Throwable cause) { super(cause); }
}
