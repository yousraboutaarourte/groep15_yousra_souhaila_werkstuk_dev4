package coffees;

public class Cream extends Extra {

    public Cream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return 0.75 + super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + " cream";
    }
}