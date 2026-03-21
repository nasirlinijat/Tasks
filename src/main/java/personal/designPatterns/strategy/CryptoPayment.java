package personal.designPatterns.strategy;

public class CryptoPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payed with crypto");
    }
}
