package coffees;

public class Milk extends Extra{
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return 0.50 + super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + " cream";
    }
}
