package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            Student merian = new Student(
                "MERIAN",
                "ck@gmail.com", LocalDate.of(2020,12,01));

            Student alex = new Student(
                    "Alex",
                    "dcdjk@gmail.com", LocalDate.of(1232,12,01));
            repository.saveAll(List.of(merian, alex));
            /*
                output on http://localhost:8080/api/v1/student
                [{"id":1,"name":"MERIAN","email":"ck@gmail.com","dob":"2020-12-01","age":20},{"id":2,"name":"Alex","email":"dcdjk@gmail.com","dob":"2022-12-01","age":21}]
             */


        };
    }
}
