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
    private static final String NO_TRANSPORT = "Транспорт отсутствует!";

    public Driver(String name, String drivingLicense) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = DEFAULT;
        }
        setDrivingLicense(drivingLicense);
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

        if (transport == null) {
            throw new IllegalArgumentException();
        }

        boolean allowDrive = false;
        switch (getDrivingLicense()) {
            case CATEGORY_B:
                allowDrive = transport instanceof Car;
                break;
            case CATEGORY_C:
                allowDrive = transport instanceof Bus;
                break;
            case CATEGORY_D:
                allowDrive = transport instanceof Truck;
                break;
        }
        if (allowDrive) {
            this.transport = transport;
        }
    }

    public void setExperience(int experience) {
        this.experience = experience > 0 && experience < 100 ? experience : DEFAULT_EXPERIENCE;
    }

    public void setDrivingLicense(String drivingLicense) {
        drivingLicense = drivingLicense.toUpperCase();
        switch (drivingLicense) {
            case CATEGORY_B:
                this.drivingLicense = CATEGORY_B;
                return;
            case CATEGORY_C:
                this.drivingLicense = CATEGORY_C;
                return;
            case CATEGORY_D:
                this.drivingLicense = CATEGORY_D;
                return;
        }
        this.drivingLicense = DEFAULT;
    }

    @Override
    public void start() {
        if (transport != null) {
            transport.start();
        } else {
            System.out.println(NO_TRANSPORT);
        }

    }

    @Override
    public void stop() {
        if (transport != null) {
            transport.stop();
        } else {
            System.out.println(NO_TRANSPORT);
        }

    }

    @Override
    public void refill() {
        if (transport != null) {
            transport.refill();
        } else {
            System.out.println(NO_TRANSPORT);
        }

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
        System.out.printf("Водитель %s управляет %s и будет участвовать в заезде\n",
                getName(),
                transport != null ? transport.toString() : NO_TRANSPORT);
    }
}
