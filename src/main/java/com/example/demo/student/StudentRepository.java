package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//jpa repo lib ini extend ettikten sonra < class , ve id tipi>
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //custom functions
    // Optional tpiinde
    // select * from student where email = ?
    // findStudentBy yazdıktan sonra email i otomatik algıladı. Daha da ozelligi var
    // kendi fonksiyonunu direkt üretti
    Optional<Student> findStudentByEmail(String email);
}
