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
        return studentRepository.getReferenceById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Student student){

        Student studentInfo = getStudent(student.getId());
        if(studentInfo==null){
            return Optional.empty();
        }
/*        studentInfo.setId(id);
        studentInfo.setFirstName(student.getFirstName());
        studentInfo.setLastName(student.getLastName());
        studentInfo.setEmail(student.getEmail());
  */

        return Optional.of(studentRepository.save(student));
    }

    public void deleteStudent(Long id){

        Student studentInfo = studentRepository.getReferenceById(id);

        studentRepository.deleteById(id);

        //FIXME geri dönüşleri kontrol et
    }

}
