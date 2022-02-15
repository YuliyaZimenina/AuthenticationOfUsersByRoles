package net.juliya.zimenina.AuthenticationOfUsersByRoles.rest;


import net.juliya.zimenina.AuthenticationOfUsersByRoles.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestControllerV1 {

    // Collection to simulate a database
    private List<Student> STUDENTS = Stream.of(
      new Student(1L, "Jack", "Jackson"),
      new Student(2L, "Emma", "Swan"),
      new Student(3L, "Paul", "Jons"),
      new Student(4L, "Mel", "Bryan"),
      new Student(5L, "Nick", "Black")
    ).collect(Collectors.toList());


    // Method that return a lost of all students
    @GetMapping
    public List<Student> allStudents(){
        return STUDENTS;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return STUDENTS.stream().filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        this.STUDENTS.add(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        this.STUDENTS.removeIf(student -> student.getId().equals(id));
    }
}
