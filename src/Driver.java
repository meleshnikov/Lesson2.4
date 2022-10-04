import transport.*;

public class Driver<T extends Transport> implements Drivable {

    private final String name;
    private T transport;
    private String drivingLicense;
    private int experience;

    private static final int DEFAULT_EXPERIENCE = 0;
    private static final String DEFAULT = "Информация отсутствует";
    private static final String CATEGORY_B = "B";
    private static final String CATEGORY_C = "C";
    private static final String CATEGORY_D = "D";

    public Driver(String name, T transport) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = DEFAULT;
        }
        setTransport(transport);
        this.experience = DEFAULT_EXPERIENCE;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public int getExperience() {
        return experience;
    }

    public T getTransport() {
        return transport;
    }

    public void setTransport(T transport) {
        if (transport != null) {
            this.transport = transport;
            setDrivingLicense(transport);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setExperience(int experience) {
        this.experience = experience > 0 && experience < 100 ? experience : DEFAULT_EXPERIENCE;
    }

    public void setDrivingLicense(T transport) {
        if (transport instanceof Car) {
            this.drivingLicense = CATEGORY_B;
        } else if (transport instanceof Truck) {
            this.drivingLicense = CATEGORY_C;
        } else if (transport instanceof Bus) {
            this.drivingLicense = CATEGORY_D;
        } else {
            this.drivingLicense = DEFAULT;
        }
    }

    @Override
    public void start() {
        transport.start();
    }

    @Override
    public void stop() {
        transport.stop();
    }

    @Override
    public void refill() {
        transport.refill();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", transport=" + transport +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", experience=" + experience +
                '}';
    }

    public void getInfo() {
        System.out.printf("Водитель %s управляет %s и будет участвовать в заезде\n", getName(), transport.toString());
    }
}
