package exceptions;

public class NotFoundException extends RuntimeException {
    private String message = "Not found :/";

    public NotFoundException() { }

    public NotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}