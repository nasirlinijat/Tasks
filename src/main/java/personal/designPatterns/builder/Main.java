package personal.designPatterns.builder;

public class Main {
    public static void main(String[] args) {
        Car toyota = Car.builder()
                .brand("Toyota")
                .color("White")
                .fuelType("Hybrid")
                .hasAC(true)
                .horsepower(203)
                .model("Camry")
                .transmission("Automatic")
                .year(2023)
                .build();
    }
}
