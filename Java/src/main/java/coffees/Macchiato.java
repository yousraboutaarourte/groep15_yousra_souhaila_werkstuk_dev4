package coffees;

public class Macchiato extends Coffee {
    private String name;
    private String description;
    private SizeCoffee size;
    private Intensity intensity;
    private double price;


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(SizeCoffee size) {
        this.size = size;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Intensity getIntensity() {
        return intensity;
    }

    @Override
    public SizeCoffee getSize() {
        return size;
    }

}
