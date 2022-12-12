package Bai1;

public class InvalidAgeException extends RuntimeException {
    private int invalidAge;

    public InvalidAgeException() {

    }

    public InvalidAgeException(String msg, int invalidAge)
    {
        super(msg);
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}
