package personal.designPatterns.factory;

public class GasolineCar implements Car {
    @Override
    public void start() {
        System.out.println("Gasoline car started");
    }
}
