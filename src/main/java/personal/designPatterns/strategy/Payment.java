package personal.designPatterns.strategy;

public class Payment {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay() {
        this.paymentStrategy.pay();
    }
}
