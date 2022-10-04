import transport.*;

import java.util.ArrayList;

public class Main {

    private static final ArrayList<Transport> vehicles = new ArrayList<>();
    private static final ArrayList<Driver> drivers = new ArrayList<>();


    public static void main(String[] args) {
        //transportTest();
        driverTest();
    }


    private static void transportTest() {

        vehicles.add(new Car("ВАЗ", "21099", 1.5));
        vehicles.add(new Car("Toyota", "Camry", 3.5));
        vehicles.add(new Car("BMW"));
        vehicles.add(new Car());

        vehicles.add(new Truck("Камаз", "65115-48", 6.7));
        vehicles.add(new Truck("MAN", "TGX"));
        vehicles.add(new Truck("ЗИЛ", "4314", 6));
        vehicles.add(new Truck("Volvo"));

        vehicles.add(new Bus("ЛиАЗ", "5256", 8));
        vehicles.add(new Bus("ПАЗ", "3206", 7.5));
        vehicles.add(new Bus("Hyundai", "Universe"));
        vehicles.add(new Bus("Volvo", "9500"));

        for (Transport vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.start();
            vehicle.stop();
            if (vehicle instanceof Competing) {
                compete((Competing) vehicle);
            }
        }
    }

    private static void compete(Competing vehicle) {
        vehicle.pitStop();
        vehicle.maxSpeed();
        vehicle.bestLapTime();
    }

    private static void driverTest() {

        drivers.add(new Driver<>("Иванов Иван Иванович", new Car("Mercedes", "GLC")));
        drivers.add(new Driver<>("Василий Васильевич Васильев", new Truck("Камаз", "43118")));
        drivers.add(new Driver<>("Петр Петрович Петренко", new Bus("Икарус", "250")));

        for (Driver driver : drivers) {
            driver.setExperience((int) (Math.random() * 10));
            System.out.println(driver);
            driver.getInfo();
            driver.start();
            driver.stop();
            driver.refill();
        }
    }
}