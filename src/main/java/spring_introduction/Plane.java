package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
public class Plane implements Vehicle{

    public Plane() {
        System.out.println("Plane bean is created");
    }

    @Override
    public void ride() {
        System.out.println("Plane rides");
    }
}
