package transport;

public class Truck extends Transport {

    private static final String TRUCK = "Грузовой автомобиль: ";

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Truck(String brand, String model) {
        super(brand, model);
    }

    public Truck(String brand) {
        super(brand);
    }

    public Truck() {
    }

    @Override
    public void start() {
        System.out.println(TRUCK + getBrand() + " " + getModel() + " начал движение!");
    }

    @Override
    public void stop() {
        System.out.println(TRUCK + getBrand() + " " + getModel() + " закончил движение!");
    }


}
