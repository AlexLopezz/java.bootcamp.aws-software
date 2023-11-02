package exceptions;

public class ConnectionException extends RuntimeException {
    private String defaultMessage = "Connection Exception Generic";
    public ConnectionException(String message) {
        super(message);
    }
}
