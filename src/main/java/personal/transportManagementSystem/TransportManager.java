package personal.transportManagementSystem;

public class TransportManager {
    public static void main(String[] args) {
        TransportType userChoice = TransportType.TAXI;
        Transport transport = getTransport(userChoice);
        double distance = 10.0;
        int passengers = 2;
        System.out.println("Transport Info: " + transport.getTransportInfo());
        System.out.println("Fare for " + passengers + " passenger(s): " +
                           transport.calculateFare(distance, passengers));
        System.out.println("Estimated time: " +
                           transport.calculateTime(distance) + " hours");
    }

    private static Transport getTransport(TransportType type) {
        return switch (type) {
            case BUS -> new Bus(1, 40);
            case BICYCLE -> new Bicycle(0.4, 7);
            case TAXI -> new Taxi(3, 90);
            case SCOOTER -> new Scooter(1, 30);
        };
    }
}

