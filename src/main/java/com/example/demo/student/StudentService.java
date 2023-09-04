package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
//    autowired  constructora eklendi
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents( ){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Student with id"+studentId+" does not exists");

        }
        studentRepository.deleteById(studentId);


    }
    //Transactional
    // once findbyid ile ogrenciyi buluyoruuz yoksa hata veriyor
    // isim uygunsa setliyoruz
    // email uygunsa setliyoruz
    // ikisinden birinde hata çıkarsa da hata dönderiyoruz
    @Transactional
    public void updateStudent(Long studentId,String name,String email) {
        Student studentById = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("student with id "+studentId+" does not exists")
        );

        if(name != null && !name.isEmpty() && !name.equals(studentById.getName())){
            studentById.setName(name);
        }
        if (email != null && !email.isEmpty() && !email.equals(studentById.getEmail())){
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent()){
                throw new IllegalStateException("email taken");
            }
            studentById.setEmail(email);
        }
    }
}
