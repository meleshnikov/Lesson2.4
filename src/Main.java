import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;

import java.util.ArrayList;

public class Main {

    private static final ArrayList<Transport> vehicles = new ArrayList<>();
    private static final ArrayList<Driver> drivers = new ArrayList<>();


    public static void main(String[] args) {

        setVehicles();

        transportTest();
        System.out.println();
        driverTest();
        System.out.println();

        checkDiags();
    }

    private static void setVehicles() {

        vehicles.add(new Car("ВАЗ", "21099", 1.5));
        vehicles.add(new Car("Toyota", "Camry", 3.5));
        vehicles.add(new Car("BMW", "X5", 3, Car.Body.CROSSOVER));
        vehicles.add(new Car());

        vehicles.add(new Truck("Камаз", "65115-48", 6.7));
        vehicles.add(new Truck("MAN", "TGX"));
        vehicles.add(new Truck("ЗИЛ", "4314", 6));
        vehicles.add(new Truck("Volvo"));

        vehicles.add(new Bus("ЛиАЗ", "5256", 8));
        vehicles.add(new Bus("ПАЗ", "3206", 7.5));
        vehicles.add(new Bus("Hyundai", "Universe"));
        vehicles.add(new Bus("Volvo", "9500"));
    }

    private static void setDrivers() {
        Car mercedes = new Car("Mercedes", "GLC");
        Truck kamaz = new Truck("Камаз", "43118");
        Bus icarus = new Bus("Икарус", "250");
        drivers.add(new DriverB("Иванов Иван Иванович", mercedes));
        drivers.add(new DriverC("Василий Васильевич Васильев", kamaz));
        drivers.add(new DriverD("Петр Петрович Петренко", icarus));
    }


    private static void transportTest() {

        for (Transport vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.start();
            vehicle.stop();
            vehicle.printType();
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

        setDrivers();

        for (Driver driver : drivers) {
            driver.setExperience((int) (Math.random() * 10));
            System.out.println(driver);
            driver.getInfo();
            driver.start();
            driver.stop();
            driver.refill();
        }
    }

    private static void checkDiags() {

        for (Transport vehicle : vehicles) {
            try {
                if (vehicle.diag()) {
                    System.out.println(vehicle.getClass().getSimpleName() + ": success diag");
                } else {
                    throw new RuntimeException(vehicle.getClass().getSimpleName() + ": diag fail!");
                }

            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}