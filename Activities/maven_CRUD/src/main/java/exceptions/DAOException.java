package exceptions;

import java.io.IOException;

public class DAOException extends IOException {
    private String message = "There was an error saving information in the database";

    public DAOException() { }

    public DAOException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
