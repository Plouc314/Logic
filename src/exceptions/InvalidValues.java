package exceptions;

public class InvalidValues extends Exception {
    public InvalidValues(String errorMessage) {
        super(errorMessage);
    }
}