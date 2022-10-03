package transport;

public class Bus extends Transport {

    private static final String BUS = "Автобус: ";

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Bus(String brand, String model) {
        super(brand, model);
    }

    public Bus(String brand) {
        super(brand);
    }

    public Bus() {
    }

    @Override
    public void start() {
        System.out.println(BUS + getBrand() + " " + getModel() + " начал движение!");
    }

    @Override
    public void stop() {
        System.out.println(BUS + getBrand() + " " + getModel() + " закончил движение!");
    }
}
