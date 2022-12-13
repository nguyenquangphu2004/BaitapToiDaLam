package Bai5;

public class InvalidDayException extends Exception{
    private int invalidDay;

    public InvalidDayException(String msg, int invalidDay) {
        super(msg);
        this.invalidDay = invalidDay;
    }

    public int getInvalidDay() {
        return invalidDay;
    }
}
