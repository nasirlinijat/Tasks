package personal.carRentalManagementSystem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CarRentalSystem {
    private final Map<Customer, Car> customerCarMap;
    private final Map<Car, LocalDateTime> carLocalDateTimeMap;
    private final Set<Car> availableCarsSet;
    private final Map<Car, LocalDateTime[]> rentalHistoryMap;

    {
        this.customerCarMap = new HashMap<>();
        this.carLocalDateTimeMap = new HashMap<>();
        this.availableCarsSet = new HashSet<>();
        this.rentalHistoryMap = new HashMap<>();
    }

    public void addCar(Car car) {
        this.availableCarsSet.add(car);
    }

    public void rentCar(Customer customer, Car car) {
        if (this.availableCarsSet.contains(car)) {
            this.customerCarMap.put(customer, car);
            this.carLocalDateTimeMap.put(car, LocalDateTime.now());
            this.availableCarsSet.remove(car);
            System.out.println("✅" + customer.getName()
                               + " rented " + car.getModel()
                               + " at " + this.carLocalDateTimeMap.get(car));
        } else System.out.println("Car is not available!");
    }

    public void returnCar(Customer customer) {
        LocalDateTime returnDate = LocalDateTime.now();
        Car car = this.customerCarMap.remove(customer);
        LocalDateTime rentalDate = this.carLocalDateTimeMap.get(car);
        this.availableCarsSet.add(car);

        LocalDateTime[] historyArray = new LocalDateTime[2];
        historyArray[0] = rentalDate;
        historyArray[1] = returnDate;
        Duration duration = Duration.between(rentalDate, rentalDate);

        this.rentalHistoryMap.put(car, historyArray);
        System.out.println("\n" + customer.getName() + " returned " + car.getModel() + " after "
                           + duration.toDays() + " days (" + duration.toHours() + " hours total)");
    }

    public void printActiveRentals() {
        System.out.println("\nActive Rentals:");
        this.customerCarMap.forEach((customer, car) ->
                System.out.println(customer.getName()
                                   + "-> " + car.getModel()
                                   + "(rented at " + this.carLocalDateTimeMap.get(car) + ")"));
    }

    public void printAvailableCars() {
        System.out.println("\nAvailable Cars:");
        this.availableCarsSet.forEach(car ->
                System.out.println(car.getBrand() + " " + car.getModel() + "(" + car.getYear() + ")"));
    }

    public void printRentalHistory() {
        System.out.println("\nRental History:");
        this.rentalHistoryMap.forEach((car, localDateTimes) ->
                System.out.println(car.getModel() + " last returned at " + localDateTimes[1]));
    }


}
