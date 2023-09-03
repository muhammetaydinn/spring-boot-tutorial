package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//jpa repo lib ini extend ettikten sonra < class , ve id tipi>
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
