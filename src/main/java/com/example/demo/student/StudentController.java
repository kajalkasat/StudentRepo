package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// this call forms the api layer, hence will have the api code
@RestController
@RequestMapping(path = "api/v1/student") // instead of getting output on localhost:8080, we want on localhost:8080/api/v1/student
public class StudentController {

    @Autowired
    private final StudentService studentservice;

    // this is calling injecting the instantiation, called as dependency injection
   // this means "studentservice" is always instantiated for the service StudentService, where the class is marked with anotation "service"

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getStudents()
    {
        return studentservice.getStudents();
    }


    @PostMapping // this is POST request of the architecure, when we want to add something to the DB
    public void registerNewStudent(@RequestBody  Student student) //@RequestBody : pick the student object from the request
    {
        studentservice.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") // delete student record from DB
    public void deleteStudent(@PathVariable("studentId") Long studentid)
    {
        studentservice.deleteStudent(studentid);
    }

    @PutMapping(path = "{studentId}")
    public void putmeansUpdateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        studentservice.putmeansUpdateStudent(studentId, name, email);
    }

}
