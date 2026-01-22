package personal.busServiceSystem;

public class BusSystem {
    private final Bus bus;

    {
        this.bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }

    public void route(BusStop busStop) {
        System.out.println("Stop" + busStop.getId() + " reached.");
        int numberOfPassengersDropped = (int) (Math.random() * 2) + 1;
        int counter = 0;
        while (counter < numberOfPassengersDropped) {
            if (!this.bus.getPassengers().isEmpty()) {
                int passengerIndex = (int) (Math.random() * (this.bus.getPassengerSize()));
                Passenger droppedPassenger = this.bus.dropPassengers(passengerIndex);
                busStop.addPassenger(droppedPassenger);
            }
            counter++;
        }
        //Filling the bus
        while (this.bus.checkIfCanTake() && busStop.getTotalBusStopSize() > numberOfPassengersDropped) { //Second condition makes sure dropped passenger do not get in the bus again
            Passenger boardedPassenger = busStop.removePassengerForDropped();
            this.bus.takePassenger(boardedPassenger);
            System.out.println(boardedPassenger.getName() + " boarded the bus.");

        }
        this.bus.getInformation();
        busStop.getInformation();
        System.out.println();
    }
}
