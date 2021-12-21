package spring_introduction;

import org.springframework.stereotype.Component;

//@Component("carBean")
public class Car implements Vehicle{
    public Car() {
        System.out.println("carBean is created");
    }

    @Override
    public void ride() {
        System.out.println("Car rides");
    }
}
