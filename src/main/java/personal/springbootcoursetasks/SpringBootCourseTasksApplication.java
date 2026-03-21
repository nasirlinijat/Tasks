package personal.springbootcoursetasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import personal.springbootcoursetasks.homework18.constructorInjection.OrderService;

@SpringBootApplication
public class SpringBootCourseTasksApplication {

    static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootCourseTasksApplication.class, args);
        OrderService orderService = (OrderService) context.getBean("orderServiceImpl");
        orderService.placeOrder();
    }

}
