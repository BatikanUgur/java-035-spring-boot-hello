package com.batikanugur.service;

import com.batikanugur.model.Student;
import com.batikanugur.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudentService {

    //Data katmanını enjekte eder.//Injection//Eski

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Student student){
        return Optional.of(studentRepository.save(student));
    }

    public void deleteStudent(Long id){

        Student studentInfo = studentRepository.getReferenceById(id);

        studentRepository.deleteById(id);

        //FIXME geri dönüşleri kontrol et
    }

}
