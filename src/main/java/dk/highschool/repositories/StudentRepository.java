package dk.highschool.repositories;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dk.highschool.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Modifying
    @Query("UPDATE Student s SET s.name = ?1, s.dateOfBirth = ?2, s.email = ?3 WHERE s.id = ?4")
    void updateStudentById(String name, Instant dateOfBirth, String email, Long id);
}
