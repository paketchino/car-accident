package car.accident;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CarAccidentApplication extends SpringBootServletInitializer {

    @Bean
    public SpringLiquibase liquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("db/changelog/liquibase-changeLog.xml");
        liquibase.setDataSource(ds);
        return liquibase;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CarAccidentApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CarAccidentApplication.class, args);
    }

}