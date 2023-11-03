package exceptions;
public class BOException extends RuntimeException {
    private String message = "There was an error in the Services Layer.";

    public BOException() { }

    public BOException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
