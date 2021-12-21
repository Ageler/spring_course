package spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
//@ComponentScan("spring_introduction")
public class MyConfig {

    @Bean
    public Vehicle carBean() {
        return new Car();
    }



    @Bean
    public Company companyBean() {
        return new Company(carBean());
    }
}
