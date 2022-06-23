package dk.highschool.initial_data;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dk.highschool.entities.Student;
import dk.highschool.repositories.StudentRepository;

@Configuration
public class StudentData {

    @Bean
    static CommandLineRunner commandLineRunner(final StudentRepository studentRepository) {
        return args -> {
            final Student daniel = new Student("Daniel", Instant.parse("1998-09-03T00:00:00Z"),
                "dkanchev1878@gmail.com", List.of());

            final Student harry = new Student("Harry", Instant.parse("1994-12-07T00:00:00Z"), "harry.knowles@gmail.com",
                List.of());
            studentRepository.save(daniel);
            studentRepository.save(harry);
        };
    }
}
