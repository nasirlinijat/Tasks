package personal.springbootcoursetasks.homework18.setterInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine engine;

    @Autowired
    public void setEngine(Engine engine){
        this.engine = engine;
    }

    public void move(){
        engine.start();
        System.out.println("Car is moving");
    }
}
