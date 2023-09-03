package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
//    bu sanırım import edildiğini gösteren kod bean de insert sanırım
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student meryem = new Student(
                    "Meryem",
                    "marima@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 15),
                    21);
            Student ali = new Student(
                    "ali",
                    "ali@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 15),
                    21);
            repository.saveAll(List.of(meryem,ali));

        };
    }
}
