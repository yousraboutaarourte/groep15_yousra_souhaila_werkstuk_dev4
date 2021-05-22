package coffees;

public class Water extends Extra {
    public Water(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return 0.10 + super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + " cream";
    }
}
