package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Company company = context.getBean("companyBean", Company.class);
        company.useVehicle();

        System.out.println(company.getName());
        System.out.println(company.getCost());
        context.close();
    }
}
