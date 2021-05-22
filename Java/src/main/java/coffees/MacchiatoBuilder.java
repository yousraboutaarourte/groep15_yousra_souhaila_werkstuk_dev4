package coffees;

public class MacchiatoBuilder implements IBuilder <Macchiato> {
    Macchiato macchiato;


    public MacchiatoBuilder() {
        this.macchiato = new Macchiato();
    }

    @Override
    public Macchiato build() {
        if(this.macchiato.getName()==null){
            throw new IllegalArgumentException("The name is required");
        }
        if(this.macchiato.getPrice()<=0){
            throw new IllegalArgumentException("The price is required");
        }
        return this.macchiato;
    }

    public IBuilder<Macchiato> name(String name) {
        this.macchiato.setName(name);
        return this;
    }

    public IBuilder<Macchiato> description(String description) {
        this.macchiato.setDescription(description);
        return this;
    }

    public IBuilder<Macchiato> size(SizeCoffee size) {
        this.macchiato.setSize(size);
        return this;
    }

    public IBuilder<Macchiato> intensity(Intensity intensity) {
        this.macchiato.setIntensity(intensity);
        return this;
    }

    public IBuilder<Macchiato> price(double price) {
        this.macchiato.setPrice(price);
        return this;
    }
}
