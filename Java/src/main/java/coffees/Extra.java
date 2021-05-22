package coffees;

public class Extra extends Coffee{
    private final Coffee coffee;

    public Extra(Coffee coffee) {
        if (coffee == null) {
            throw new IllegalArgumentException();
        }
        this.coffee = coffee;
    }

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
