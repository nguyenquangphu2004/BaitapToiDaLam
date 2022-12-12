package Bai2;

public class AccountBank {
    private String cardNumber;
    private String accountNumber;
    private String accountName;
    private int balance;

    public AccountBank(String cardNumber, String accountNumber,
                       String accountName, int balance) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean withDraw(int amount) throws InvalidAmoutException {
        if(balance >= amount && amount >= 0) {
            balance -= amount;
            return true;
        } else {
            amount = 0;
            String msg = "Số tiền rút lớn hơn số tiền trong tài khoản!";
            throw new InvalidAmoutException(msg,amount);
        }
//        Rút tiền
    }
    public boolean transfer(AccountBank account, int amount) throws InvalidAmoutException {
        if(balance >= amount && amount >= 0) {
            balance -= amount;
            account.setBalance(account.getBalance() + amount);
            return true;
        } else {
            String msg = "Số tiền chuyển lớn hơn số tiền trong tài khoản!";
            throw new InvalidAmoutException(msg, 0);
        }
//        Chuyển tiền
    }
    public boolean pay(int amount, String service) throws InvalidAmoutException {
        if(balance >= amount && amount >= 0) {
            balance -= amount;
            return true;
        } else {
           String msg = "Số tiền thanh toán lớn hơn số tiền trong tài khoản";
           throw new InvalidAmoutException(msg, 0);
        }
//        Thanh toán ....
    }

    @Override
    public String toString() {
        return "AccountBank[" +
                "cardNumber='" + cardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' + "\n" +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ']';
    }
}
