package personal.designPatterns.strategy;

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setPaymentStrategy(new CardPayment());
        payment.pay();

        payment.setPaymentStrategy(new CryptoPayment());
        payment.pay();
    }
}
