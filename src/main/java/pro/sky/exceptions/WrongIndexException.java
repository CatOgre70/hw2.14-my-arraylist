package pro.sky.exceptions;

public class WrongIndexException extends RuntimeException{

    public WrongIndexException() {
        super();
    }

    public WrongIndexException(String message) {
        super(message);
    }
}
