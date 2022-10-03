package transport;

public class Truck extends Transport implements Competing {

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

    @Override
    public void pitStop() {
        System.out.println("Грузовик. Пит-стоп!");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время круга для грузовика: ");
    }

    @Override
    public void maxSpeed() {
        System.out.println("максимальная скорость авто: ");

    }


}
