package personal.springbootcoursetasks.homework18.constructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    private final PaymentService paymentService;
    private final DeliveryService deliveryService;

    @Autowired
    public OrderServiceImpl(PaymentService paymentService,
                            DeliveryService deliveryService) {
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
    }

    @Override
    public void placeOrder() {
        System.out.println("Placing order...");
        paymentService.processPayment();
        deliveryService.deliverOrder();
        System.out.println("Order complete.");
    }}
