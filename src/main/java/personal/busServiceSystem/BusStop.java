package personal.busServiceSystem;

import java.util.*;

public class BusStop {
    private final int id;
    private static final int MAXIMUM_SIZE = 10;
    private final Queue<Passenger> ordinaryPassengers;
    private final Queue<Passenger> priorityPassengers;
    private final Queue<Passenger> allPassengers;

    public BusStop(int id) {
        this.id = id;
        this.ordinaryPassengers = new ArrayDeque<>();
        this.priorityPassengers = new ArrayDeque<>();
        this.allPassengers = new ArrayDeque<>();
    }

    public Queue<Passenger> getOrdinaryPassengers() {
        return ordinaryPassengers;
    }

    public Queue<Passenger> getPriorityPassengers() {
        return priorityPassengers;
    }


    public int getId() {
        return id;
    }

    public int getTotalBusStopSize() {
        return this.allPassengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if (getTotalBusStopSize() < MAXIMUM_SIZE) {
            if (passenger.isPriority()) {
                this.priorityPassengers.offer(passenger);
            } else {
                this.ordinaryPassengers.offer(passenger);
            }
            this.allPassengers.offer(passenger);
        }
    }

    public Passenger removePassengerForDropped() {
      if (!this.allPassengers.isEmpty()){
          Passenger passenger = this.allPassengers.poll();
          if (passenger.isPriority()) {
              this.priorityPassengers.poll();
          }else {
              this.ordinaryPassengers.poll();
          }
          return passenger;
      }
      return null;
    }

    public Passenger removePassenger() {
        if (!this.priorityPassengers.isEmpty()) {
            Passenger passenger = this.priorityPassengers.poll();
            this.allPassengers.poll();
            return passenger;
        } else {
            if (!this.ordinaryPassengers.isEmpty()) {
                Passenger passenger = this.ordinaryPassengers.poll();
                this.allPassengers.poll();
                return passenger;
            }
        }
        return null;
    }

    public void getInformation(){
        System.out.println("Stop" + getId() + " remaining: " + this.allPassengers);
    }

}
