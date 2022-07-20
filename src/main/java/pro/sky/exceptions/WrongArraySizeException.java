package pro.sky.exceptions;

public class WrongArraySizeException extends RuntimeException{

    public WrongArraySizeException() {
    }

    public WrongArraySizeException(String message) {
        super(message);
    }

}
