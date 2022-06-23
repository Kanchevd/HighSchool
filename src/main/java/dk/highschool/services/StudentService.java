package dk.highschool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.highschool.entities.Student;
import dk.highschool.repositories.StudentRepository;
import dk.highschool.values.StudentDto;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(final Student student) {
        studentRepository.findStudentByEmail(student.getEmail()).ifPresent(st -> {
            throw new IllegalArgumentException("Email is already taken!");
        });
        return studentRepository.save(student);
    }

    public void deleteStudent(final Long id) {
        studentRepository.findById(id).ifPresentOrElse(st -> {
            studentRepository.deleteById(id);
        }, () -> {
            throw new IllegalArgumentException("No such student!");
        });

    }

    @Transactional
    public Student updateStudent(final Long id, final StudentDto updatedFields) {
        studentRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("No such student!");
        });

        final Student student = studentRepository.getReferenceById(id);

        if (updatedFields.name() != null) {
            student.setName(updatedFields.name());
        }

        if (updatedFields.dateOfBirth() != null) {
            student.setDateOfBirth(updatedFields.dateOfBirth());
        }

        if (updatedFields.email() != null) {
            student.setEmail(updatedFields.email());
        }

        studentRepository.save(student);
        return student;
    }
}
