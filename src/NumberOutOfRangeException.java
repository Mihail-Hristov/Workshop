public class NumberOutOfRangeException extends Exception{
    String message;

    public NumberOutOfRangeException (String message) {
        super(message);
    }
}
