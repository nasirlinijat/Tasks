package personal.springbootcoursetasks.homework18.constructorInjection;

import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService{
    @Override
    public void deliverOrder() {
        System.out.println("Order delivered successfully.");
    }

}
