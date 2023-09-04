package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    //aynı servis olduklarını belirtmek için @Autowired kullanılır
    //ve o servis de @Service anotasyonu kullanılır
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents( ){
        return  studentService.getStudents();
    }
    // post map için ornek ogrenci kaydı
    // bu fonksiyonu PostMapping ile tanımlarız
    // ogrenci datası girmek icin Student i @RequestBody tipinde tanımlarız
    //içine de servisimiz. { istediğimizfonksiyonuadı}  yazar hata gelinc
    // servise create method deriz
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //delete student

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }
    //Put mapping i giriyoruz ve pathi ekliyoruz
    // ardından pathvariable olan studentid yi fonksiyona ekliyoruz
    //bodyde olması gereken verilerin ve required durumlarını ekliyoruz
    //REQUEST PARAM ile istediğimiz parametreleri ekliyoruz
    // REQUEST BODY FARKLI BU PARAMETRE OLUR /1/name?ali gibi
    @PutMapping(path ="{studentId}" )
    public void updateStudent(@PathVariable("studentId") Long studentId,
                                @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email
                              ){
        studentService.updateStudent(studentId,name,email);
    }
}
