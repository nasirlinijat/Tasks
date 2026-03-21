package personal.designPatterns.factory;

public class Main {
    public static void main(String[] args) {
        Car gasolineCar = CarFactory.create("gasoline");
        gasolineCar.start();

        Car electricCar = CarFactory.create("electric");
        electricCar.start();
    }


}
