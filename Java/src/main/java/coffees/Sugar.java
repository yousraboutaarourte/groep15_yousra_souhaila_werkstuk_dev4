package coffees;

public class Sugar extends Extra {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return 0.25 + super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + " cream";
    }
}
