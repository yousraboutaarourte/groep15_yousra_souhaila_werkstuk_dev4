package coffees;

public class EspressoBuilder implements IBuilder <Espresso>{
    Espresso espresso;

    public EspressoBuilder() {
        this.espresso = new Espresso();
    }

    @Override
    public Espresso build() {
        if(this.espresso.getName()==null){
            throw new IllegalArgumentException("The name is required");
        }
        if(this.espresso.getPrice()<=0){
            throw new IllegalArgumentException("The price is required");
        }
        return this.espresso;
    }

    public IBuilder<Espresso> name(String name) {
        this.espresso.setName(name);
        return this;
    }

    public IBuilder<Espresso> description(String description) {
        this.espresso.setDescription(description);
        return this;
    }

    public IBuilder<Espresso> size(SizeCoffee size) {
        this.espresso.setSize(size);
        return this;
    }

    public IBuilder<Espresso> intensity(Intensity intensity) {
        this.espresso.setIntensity(intensity);
        return this;
    }

    public IBuilder<Espresso> price(double price) {
        this.espresso.setPrice(price);
        return this;
    }
}
