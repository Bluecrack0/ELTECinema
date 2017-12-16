package hu.elte.inf.alkfejl.cinema.exception;

public class DuplicatedDataException extends Exception {

    public DuplicatedDataException(String message) {
        super(message);
    }

    public DuplicatedDataException() {
        super();
    }
}
