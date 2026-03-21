package personal.springbootcoursetasks.homework18.constructorInjection;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine started");
    }
}
