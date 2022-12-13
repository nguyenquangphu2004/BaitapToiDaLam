package Bai2;

public class InvalidAmoutException extends Exception{

    private int invalidAmount;
    public InvalidAmoutException() {

    }

    public InvalidAmoutException(String msg, int invalidAmount) {
        super(msg);
        this.invalidAmount = invalidAmount;
    }

    public int getInvalidAmount() {
        return invalidAmount;
    }
}
