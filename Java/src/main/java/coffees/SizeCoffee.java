package coffees;

public enum SizeCoffee {
    S("Small"), M("Medium"), L("Large");

    private final String size;

    SizeCoffee(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
