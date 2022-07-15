package pro.sky.exceptions;

public class ElementNotFoundInTheArrayListException extends RuntimeException{

    public ElementNotFoundInTheArrayListException() {
        super();
    }

    public ElementNotFoundInTheArrayListException(String message) {
        super(message);
    }
}
