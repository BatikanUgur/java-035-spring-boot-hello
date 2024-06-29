package com.batikanugur;

import com.batikanugur.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Hello Spring Boot");
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("Batıkan");
        student.setLastName("Tizer");
        student.setEmail("btkn@gmail.com");

        System.out.println(student);
    }

}
