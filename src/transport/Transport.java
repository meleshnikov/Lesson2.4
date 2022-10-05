package transport;

public abstract class Transport implements Drivable {
    private String brand;
    private String model;
    private double engineVolume;

    private static final String DEFAULT = "default";
    private static final double DEFAULT_ENGINE = 0.0;

    public Transport(String brand, String model, double engineVolume) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
    }

    public Transport(String brand, String model) {
        this(brand, model, DEFAULT_ENGINE);
    }

    public Transport(String brand) {
        this(brand, DEFAULT);
    }

    public Transport() {
        this(DEFAULT);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setBrand(String brand) {
        this.brand = isValid(brand) ? brand : DEFAULT;
    }

    public void setModel(String model) {
        this.model = isValid(model) ? model : DEFAULT;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume > 0 && engineVolume < 20 ? engineVolume : DEFAULT_ENGINE;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel();
    }

    abstract public void printType();

    protected static boolean isValid(String field) {
        return field != null && !field.isEmpty() && !field.isBlank();
    }


}
