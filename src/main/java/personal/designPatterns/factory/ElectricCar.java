package personal.designPatterns.factory;

public class ElectricCar implements Car {
    @Override
    public void start() {
        System.out.println("Electric car started");
    }
}
