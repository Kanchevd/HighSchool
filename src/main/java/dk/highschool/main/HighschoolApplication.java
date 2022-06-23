package dk.highschool.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "dk.highschool.controllers", "dk.highschool.services", "dk.highschool.entities", "dk.highschool.repositories",
    "dk.highschool.initial_data"
})
@EntityScan(basePackages = {
    "dk.highschool.entities"
})
@EnableJpaRepositories("dk.highschool.repositories")
public class HighschoolApplication {

    public static void main(final String[] args) {
        SpringApplication.run(HighschoolApplication.class, args);
    }
}
