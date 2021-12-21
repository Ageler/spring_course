package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Vehicle car = applicationContext.getBean("car", Vehicle.class);
        car.ride();
        applicationContext.close();
    }
}
