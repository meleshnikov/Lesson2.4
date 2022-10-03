package transport;

public class Car extends Transport {

    private static final String CAR = "Легковой автомобиль: ";

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Car(String brand, String model) {
        super(brand, model);
    }

    public Car(String brand) {
        super(brand);
    }

    public Car() {
    }

    @Override
    public void start() {
        System.out.println(CAR + getBrand() + " " + getModel() + " начал движение!");
    }

    @Override
    public void stop() {
        System.out.println(CAR + getBrand() + " " + getModel() + " закончил движение!");
    }
}
