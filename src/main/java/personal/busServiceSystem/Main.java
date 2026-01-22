package personal.busServiceSystem;

public class Main {
    public static void main(String[] args) {
        BusSystem busSystem = new BusSystem();

        BusStop busStop1 = new BusStop(1);
        BusStop busStop2 = new BusStop(2);
        BusStop busStop3 = new BusStop(3);

        Passenger passenger1 = new Passenger("Aysel", true);
        Passenger passenger2 = new Passenger("Nigar", true);
        Passenger passenger3 = new Passenger("Murad", false);
        Passenger passenger4 = new Passenger("Samir", true);
        Passenger passenger5 = new Passenger("Rauf", false);
        Passenger passenger6 = new Passenger("Ali", false);

        busStop1.addPassenger(passenger1);
        busStop1.addPassenger(passenger2);

        busStop2.addPassenger(passenger3);
        busStop2.addPassenger(passenger4);

        busStop3.addPassenger(passenger5);
        busStop3.addPassenger(passenger6);


        busSystem.route(busStop1);
        busSystem.route(busStop2);
        busSystem.route(busStop3);
        System.out.println("✅ Simulation finished.");
        busSystem.getBus().getInformation();
    }
}
