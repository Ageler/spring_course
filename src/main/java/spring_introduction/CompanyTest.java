package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Company company = context.getBean("company", Company.class);
        company.useVehicle();
        System.out.println(company.getCost());
        System.out.println(company.getName());
        context.close();
    }
}
