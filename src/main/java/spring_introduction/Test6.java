package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Company company = context.getBean("companyBean", Company.class);
        System.out.println(company.getCost());
        System.out.println(company.getName());
        context.close();
    }
}
