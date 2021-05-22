package coffees;

public interface IBuilder <T>{
    T build();
    IBuilder<T> name(String name);
    IBuilder<T> description(String description);
    IBuilder<T> size(SizeCoffee size);
    IBuilder<T> intensity(Intensity intensity);
    IBuilder<T> price(double price);
}
