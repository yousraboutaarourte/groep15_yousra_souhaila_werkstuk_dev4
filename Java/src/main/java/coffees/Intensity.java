package coffees;

public enum Intensity {
    LIGHT("Light"), MEDIUM("Medium"), STRONG("Strong");

    private final String intensity;

    Intensity(String intensity) {
        this.intensity = intensity;
    }

    public String getIntensity() {
        return intensity;
    }
}
