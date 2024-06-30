package com.batikanugur.controller;

import com.batikanugur.model.Student;
import com.batikanugur.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//http:localhost:8090/api/v1
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    // IoC
    // DI
    //Servis Enjekte Ediliyor //Injection//Eski

    /*
    @Autowired
    StudentService studentService;
*/
    //Yeni
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/hello")
    public String hello() {

        return "Hello Spring Boot - Student Controller";
    }

    //Get - select all
    //http:localhost:8090/api/v1/students
    @GetMapping("/students/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //Get * select where
    //http:localhost:8090/api/v1/student/1
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable (name = "id") Long id) {
        return studentService.getStudent(id);
    }

    //Post - Insert
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }


    // Put - Update
    @PutMapping("/student/{id}")
    public Optional<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        //id değeri var mı yok mu?

        Student studentInfo = studentService.getStudent(id);

        if (studentInfo == null) {
            return Optional.empty();
        } else {

            student.setId(id);

            return studentService.updateStudent(student);
        }
    }

    // Delete - Delete
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
         studentService.deleteStudent(id);
         return "OK";
    }
}
