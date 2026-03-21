package personal.springbootcoursetasks.homework18.constructorInjection;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public void processPayment() {
        System.out.println("Payment processed successfully.");
    }
}
