package personal.transportManagementSystem;

public class Bicycle implements Transport {

    private final double ratePerKm;
    private final double speed;

    public Bicycle(double ratePerKm, double speed) {
        this.ratePerKm = ratePerKm;
        this.speed = speed;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * this.ratePerKm;
    }

    @Override
    public double calculateFare(double distance, int passengers) {
        return calculateFare(distance) * passengers;
    }

    @Override
    public double calculateTime(double distance) {
        double time = distance / this.speed;
        return Math.round(time * 100.0) / 100.0;
    }

    @Override
    public String getTransportInfo() {
        return "Rate Per Kilometre: " + this.ratePerKm
               + "\nSpeed: " + this.speed;
    }
}
