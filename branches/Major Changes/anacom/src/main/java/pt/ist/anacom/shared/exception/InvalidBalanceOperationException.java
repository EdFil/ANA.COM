package pt.ist.anacom.shared.exception;

public class InvalidBalanceOperationException extends PhoneException {

    private static final long serialVersionUID = 1L;

    private String phoneNumber;
    private int phoneBalance;

    public InvalidBalanceOperationException() {

    }

    public InvalidBalanceOperationException(String number, int balance) {
        super("Phone balance must be between 0 and 10000. [" + number + " has:" + balance + " ]");
        this.phoneNumber = number;
        this.phoneBalance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPhoneBalance() {
        return phoneBalance;
    }

}
