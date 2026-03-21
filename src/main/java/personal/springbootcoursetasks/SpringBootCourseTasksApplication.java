package personal.springbootcoursetasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import personal.springbootcoursetasks.homework18.constructorInjection.Car;

@SpringBootApplication
public class SpringBootCourseTasksApplication {

    static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootCourseTasksApplication.class, args);
        Car car = (Car) context.getBean("car");
        car.move();

    }

}
