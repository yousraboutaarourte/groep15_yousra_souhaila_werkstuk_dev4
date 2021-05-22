package coffees;

public class Extra extends Coffee{
    @Override
    public String getName() {
        return coffee.getName();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getPrice() {
        return coffee.getPrice();
    }
}
