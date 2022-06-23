package dk.highschool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.highschool.entities.Student;
import dk.highschool.services.StudentService;
import dk.highschool.values.StudentDto;

@RestController
@RequestMapping(path = "students")
public final class StudentController extends BaseController {

    private final StudentService studentService;

    @Autowired
    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping(path = "create")
    public Student createStudent(@RequestBody final StudentDto student) {
        return studentService
            .createStudent(new Student(student.name(), student.dateOfBirth(), student.email(), List.of()));
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") final Long id) {
        studentService.deleteStudent(id);
    }

    @PatchMapping(path = "{studentId}")
    public Student updateStudent(@PathVariable("studentId") final Long id,
                                 @RequestBody final StudentDto updatedFields) {
        return studentService.updateStudent(id, updatedFields);
    }

}
