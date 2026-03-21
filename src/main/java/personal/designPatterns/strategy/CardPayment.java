package personal.designPatterns.strategy;

public class CardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payed with card");
    }
}
