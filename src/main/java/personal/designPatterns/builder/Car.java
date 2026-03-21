package personal.designPatterns.builder;

public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final String color;
    private final String fuelType;
    private final String transmission;
    private final int horsepower;
    private final boolean hasAC;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.fuelType = builder.fuelType;
        this.transmission = builder.transmission;
        this.horsepower = builder.horsepower;
        this.hasAC = builder.hasAC;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private String brand;
        private String model;
        private int year;
        private String color;
        private String fuelType;
        private String transmission;
        private int horsepower;
        private boolean hasAC;


        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder fuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public Builder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public Builder horsepower(int horsepower) {
            this.horsepower = horsepower;
            return this;
        }

        public Builder hasAC(boolean hasAC) {
            this.hasAC = hasAC;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
