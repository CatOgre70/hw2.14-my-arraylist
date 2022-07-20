package pro.sky.exceptions;

public class NullArgumentException extends RuntimeException{

    public NullArgumentException() {
        super();
    }

    public NullArgumentException(String message) {
        super(message);
    }

}
