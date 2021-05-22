package coffees;

public class BancontactPayment implements Payment {
    private String cardNumber;
    private String expDate;

    public BancontactPayment(String cardNumber, String expDate) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public boolean transfer(double amount) {
        if (cardNumber.equals("67051422554321") && expDate.equals("11/30")) {
            System.out.println("The amount of " + amount + " EUR was paid via Bancontact");
            return true;
        }
        throw new IllegalArgumentException("Account doesn't exist, please contact your bank");

    }
}
