import transport.*;

import java.util.ArrayList;

public class Main {

    private static final ArrayList<Transport> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        transportTest();
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
            if (vehicle instanceof Competable) {
                testInterface((Competable) vehicle);
            }
        }
    }

    private static void testInterface(Competable vehicle) {
        vehicle.pitStop();
        vehicle.maxSpeed();
        vehicle.bestLapTime();
    }


}