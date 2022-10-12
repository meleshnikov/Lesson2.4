import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import service.Mechanic;
import service.Sponsor;
import transport.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Transport> vehicles = new ArrayList<>();
    private static final List<Driver> drivers = new ArrayList<>();

    private static final List<Sponsor> sponsors = new ArrayList<>();


    public static void main(String[] args) {

        setVehicles();

        setSponsors();

        setDrivers();

        //testSponsors();
        testMechanic();

    }

    private static void setVehicles() {

        vehicles.add(new Car("ВАЗ", "21099", 1.5));
        vehicles.add(new Car("Toyota", "Camry", 3.5));
        vehicles.add(new Car("BMW", "X5", 3, Car.Body.CROSSOVER));

        vehicles.add(new Truck("Камаз", "65115-48", 6.7));
        vehicles.add(new Truck("MAN", "TGX"));
        vehicles.add(new Truck("ЗИЛ", "4314", 6));
        vehicles.add(new Truck("Volvo"));

        vehicles.add(new Bus("ЛиАЗ", "5256", 8));
        vehicles.add(new Bus("ПАЗ", "3206", 7.5));
        vehicles.add(new Bus("Hyundai", "Universe"));
        vehicles.add(new Bus("Volvo", "9500"));
    }

    private static void setSponsors() {
        sponsors.add(new Sponsor("Петр Иванович", 5_000_000));
        sponsors.add(new Sponsor("Газпром", 3_000_000));
        sponsors.add(new Sponsor("Андрей Михайлович", 500_000));
    }


    private static void setDrivers() {
        Car mercedes = new Car("Mercedes", "GLC");
        Truck kamaz = new Truck("Камаз", "43118");
        Bus icarus = new Bus("Икарус", "250");
        drivers.add(new DriverB("Иванов Иван Иванович", mercedes));
        drivers.add(new DriverC("Василий Васильевич Васильев", kamaz));
        drivers.add(new DriverD("Петр Петрович Петренко", icarus));
    }

    private static void testSponsors() {
        for (Sponsor sponsor : sponsors) {
            sponsor.donate(Math.random() * 100_000, vehicles);
        }

        for (Transport vehicle : vehicles) {
            System.out.println(vehicle);
            System.out.println(vehicle.getSponsors());
        }
    }

    private static void testMechanic() {
        Mechanic<Car> oleg = new Mechanic<>("Олег", "Олегов", "Авто49");
        Mechanic<Transport> alex = new Mechanic<>("Алексей", "Алексеев", "Helix");
        for (Transport vehicle : vehicles) {
            if (vehicle instanceof Car) {
                oleg.service((Car) vehicle);
                oleg.repair((Car) vehicle);
            }
            alex.service(vehicle);
            alex.repair(vehicle);
        }
    }

}