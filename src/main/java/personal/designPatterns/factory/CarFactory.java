package personal.designPatterns.factory;

public class CarFactory {
    public static Car create(String type) {
        return switch (type.toLowerCase()) {
            case "gasoline" -> new GasolineCar();
            case "electric" -> new ElectricCar();
            default -> throw new RuntimeException("Not available type");
        };
    }
}
