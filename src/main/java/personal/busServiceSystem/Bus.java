package personal.busServiceSystem;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private final static int MAXIMUM_SIZE = 5;
    private final List<Passenger> passengers;

    public Bus() {
        this.passengers = new ArrayList<>();
    }

    public int getPassengerSize() {
        return this.passengers.size();
    }

    public boolean checkIfCanTake() {
        return getPassengerSize() < MAXIMUM_SIZE;
    }

    public void takePassenger(Passenger passenger) {
        if (checkIfCanTake()) {
            this.passengers.add(passenger);
        }
    }


    public Passenger dropPassengers(int droppedPassengerIndex) {
        return this.passengers.remove(droppedPassengerIndex);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void getInformation() {
        System.out.println("Bus now: " + this.passengers);
    }
}
