package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("companyBean")
public class Company {
    private Vehicle vehicle;
    @Value("${company.name}")
    private String name;
    @Value("${company.cost}")
    private int cost;

   // @Autowired
    public Company(@Qualifier("carBean") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

  //  @PostConstruct
    public void init() {
        System.out.println("start init method");
    }

   // @PreDestroy
    public void destroy() {
        System.out.println("destroy method");
    }

    public void useVehicle() {
        System.out.println("What company use:");
        vehicle.ride();
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setName(String name) {
        System.out.println("name injected");
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
