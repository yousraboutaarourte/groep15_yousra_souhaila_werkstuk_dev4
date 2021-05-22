package coffees;

public class CappucinoBuilder implements IBuilder <Cappuccino>  {
    Cappuccino cappuccino;

    public CappucinoBuilder() {
        this.cappuccino = new Cappuccino();
    }

    @Override
    public Cappuccino build() {
        if(this.cappuccino.getName()==null){
            throw new IllegalArgumentException("The name is required");
        }
        if(this.cappuccino.getPrice()<=0){
            throw new IllegalArgumentException("The price is required");
        }
        return this.cappuccino;
    }

    public IBuilder<Cappuccino> name(String name) {
        this.cappuccino.setName(name);
        return this;
    }

    public IBuilder<Cappuccino> description(String description) {
        this.cappuccino.setDescription(description);
        return this;
    }

    public IBuilder<Cappuccino> size(SizeCoffee size) {
        this.cappuccino.setSize(size);
        return this;
    }

    public IBuilder<Cappuccino> intensity(Intensity intensity) {
        this.cappuccino.setIntensity(intensity);
        return this;
    }

    public IBuilder<Cappuccino> price(double price) {
        this.cappuccino.setPrice(price);
        return this;
    }
}
