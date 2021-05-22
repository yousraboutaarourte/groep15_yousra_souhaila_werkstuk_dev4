package coffees;

public class PaypalPayment implements Payment{
    private String username;
    private String password;

    public PaypalPayment(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean transfer(double amount) {
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("The amount of " + amount + " EUR was paid via Paypal");
            return true;
        }
        throw new IllegalArgumentException("Account doesn't exist !");
    }
}
