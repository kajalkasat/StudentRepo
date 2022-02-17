package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// this interface is for data access, basically the database layer that connects and retrives value from database (her eits postgresql)
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //@Override
    @Query("FROM Student WHERE email = ?1")
    // its like SELECT * FROM student WHERE email = ?(this ? means whatever we pass)
    Optional<Student> findStudentByEmail(String email);

}
